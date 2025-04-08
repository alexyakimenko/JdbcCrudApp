package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.League;
import me.alexyack.crudjdbc.repository.LeagueRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LeagueRepositoryImpl implements LeagueRepository {

    private final JdbcClient jdbcClient;

    @Override
    @Transactional
    public List<League> findAll() {
        return jdbcClient
                .sql("select * from leagues")
                .query(League.class)
                .list();
    }

    @Override
    @Transactional
    public Optional<League> findById(Long id) {
        return jdbcClient
                .sql("select * from leagues where id = :id")
                .param("id", id)
                .query(League.class)
                .optional();
    }

    @Override
    @Transactional
    public League save(League league) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
            .sql("insert into leagues (name) values (:name) returning id")
            .param("name", league.getName())
            .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("League with id " + league.getId() + " not found")
        );
    }

    @Override
    @Transactional
    public League update(League league) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
            .sql("update leagues set name = :name where id = :id returning id")
            .param("name", league.getName())
            .param("id", league.getId())
            .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("League with id " + league.getId() + " not found")
        );
    }

    @Override
    @Transactional
    public League delete(Long id) {
        var league = findById(id).orElseThrow(
                () -> new IllegalStateException("League with id " + id + " not found")
        );

        jdbcClient
            .sql("delete from leagues where id = :id")
            .param("id", id)
            .update();

        return league;
    }
}
