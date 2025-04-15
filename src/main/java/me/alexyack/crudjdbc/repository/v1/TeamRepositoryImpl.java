package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Team;
import me.alexyack.crudjdbc.repository.CoachRepository;
import me.alexyack.crudjdbc.repository.LeagueRepository;
import me.alexyack.crudjdbc.repository.PlayerRepository;
import me.alexyack.crudjdbc.repository.TeamRepository;
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
public class TeamRepositoryImpl implements TeamRepository {

    private final JdbcClient jdbcClient;
    private final CoachRepository coachRepository;
    private final LeagueRepository leagueRepository;
    private final PlayerRepository playerRepository;

    @Override
    @Transactional
    public List<Team> findAll() {
        var teams = jdbcClient
                .sql("select * from teams")
                .query(this.teamRowMapper())
                .list();

        teams.forEach(this::getRelatedObjects);

        return teams;
    }

    @Override
    @Transactional
    public Optional<Team> findById(Long id) {
        var team = jdbcClient
                .sql("select * from teams where id = :id")
                .param("id", id)
                .query(this.teamRowMapper())
                .optional();

        team.ifPresent(this::getRelatedObjects);

        return team;
    }

    @Override
    @Transactional
    public Team save(Team team) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("insert into teams (name, coach_id, league_id) values (:name, :coachId, :leagueId) returning id")
                .param("name", team.getName())
                .param("coachId", team.getCoachId())
                .param("leagueId", team.getLeagueId())
                .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Team with id " + team.getId() + " not found")
        );
    }

    @Override
    public Team update(Team team) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("update teams set " +
                        "name = :name, " +
                        "coach_id = :coachId, " +
                        "league_id = :leagueId " +
                        "where id = :id returning id")
                .param("name", team.getName())
                .param("coachId", team.getCoachId())
                .param("leagueId", team.getLeagueId())
                .param("id", team.getId())
                .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Team with id " + team.getId() + " not found")
        );
    }

    private void getRelatedObjects(Team team) {
        var coach = coachRepository.findById(team.getCoachId()).orElse(null);

        team.setCoach(coach);

        var leagueId = team.getLeagueId();

        if(leagueId != null) {
            var league = leagueRepository.findById(leagueId).orElse(null);
            team.setLeague(league);
        }

        var players = playerRepository.findByField("team_id", team.getId());
        team.setPlayers(players);
    }

    private RowMapper<Team> teamRowMapper() {
        return (rs, rowNum) -> Team.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .leagueId(rs.getLong("league_id"))
                .coachId(rs.getLong("coach_id"))
                .build();
    }
}
