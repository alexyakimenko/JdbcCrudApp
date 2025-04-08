package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Player;
import me.alexyack.crudjdbc.repository.PlayerRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {

    private final JdbcClient jdbcClient;

    @Override
    @Transactional
    public List<Player> findByIds(List<Long> ids) {
        return jdbcClient
                .sql("select * from players where id in (:ids)")
                .param("ids", ids)
                .query(Player.class)
                .list();
    }

    @Override
    public List<Player> findByField(String field, Object value) {
        return jdbcClient // Possible sql injection
                .sql("select * from players where " + field +" = :value")
                .param("value", value)
                .query(Player.class)
                .list();
    }
}
