package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Player;
import me.alexyack.crudjdbc.model.PlayerStatistics;
import me.alexyack.crudjdbc.model.Team;
import me.alexyack.crudjdbc.repository.PlayerRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {

    private final JdbcClient jdbcClient;

    @Override
    public List<Player> findAll() {
        var players = jdbcClient
                .sql("select * from players")
                .query(this.playerRowMapper())
                .list();

        players.forEach(this::getRelatedObjects);

        return players;
    }

    @Override
    public Optional<Player> findById(Long id) {
        var player = jdbcClient
                .sql("select * from players where id = :id")
                .param("id", id)
                .query(this.playerRowMapper())
                .optional();

        player.ifPresent(this::getRelatedObjects);

        return player;
    }

    @Override
    @Transactional
    public List<Player> findByIds(List<Long> ids) {
        return jdbcClient
                .sql("select * from players where id in (:ids)")
                .param("ids", ids)
                .query(this.playerRowMapper())
                .list();
    }

    @Override
    public List<Player> findByField(String field, Object value) {
        return jdbcClient // Possible sql injection
                .sql("select * from players where " + field +" = :value")
                .param("value", value)
                .query(this.playerRowMapper())
                .list();
    }

    @Override
    @Transactional
    public Player save(Player player) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("insert into players (name, team_id) values (:name, :teamId) returning id")
                .param("name", player.getName())
                .param("teamId", player.getTeamId())
                .update(keyHolder);

        jdbcClient
                .sql("insert into players_statistics (player_id) values (:playerId)")
                .param("playerId", keyHolder.getKeyAs(Long.class))
                .update();

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Player with id " + player.getId() + " not found")
        );
    }

    @Override
    public Player update(Player player) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("update players set " +
                        "name = :name, " +
                        "team_id = :teamId " +
                        "where id = :id returning id")
                .param("id", player.getId())
                .param("name", player.getName())
                .param("teamId", player.getTeamId())
                .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Player with id " + player.getId() + " not found")
        );
    }

    private void getRelatedObjects(Player player) {
        var statistics = jdbcClient
                .sql("select * from players_statistics where player_id = :player_id")
                .param("player_id", player.getId())
                .query(PlayerStatistics.class)
                .optional().orElse(null);

        var team = jdbcClient
                .sql("select * from teams where id = :team_id")
                .param("team_id", player.getTeamId())
                .query(Team.class)
                .optional().orElse(null);

        player.setStatistics(statistics);
        player.setTeam(team);
    }

    private RowMapper<Player> playerRowMapper() {
        return ((rs, rowNum) -> Player.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .teamId(rs.getLong("team_id"))
                .build());
    }
}
