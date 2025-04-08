package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Coach;
import me.alexyack.crudjdbc.repository.CoachRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CoachRepositoryImpl implements CoachRepository {

    private final JdbcClient jdbcClient;

    @Override
    @Transactional
    public List<Coach> findAll() {
        return jdbcClient
                .sql("select * from coaches")
                .query(Coach.class)
                .list();
    }

    @Override
    @Transactional
    public Optional<Coach> findById(Long id) {
        return jdbcClient
                .sql("select * from coaches where id = :id")
                .param("id", id)
                .query(Coach.class)
                .optional();
    }

    @Override
    @Transactional
    public List<Coach> findByField(String field, Object value) {
        return jdbcClient // Possible sql injection
                .sql("select * from coaches where " + field +" = :value")
                .param("value", value)
                .query(Coach.class)
                .list();
    }

    @Override
    @Transactional
    public Coach save(Coach coach) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("insert into coaches (name) values (:name) returning id")
                .param("name", coach.getName())
                .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Coach with id " + coach.getId() + " not found")
        );
    }

    @Override
    @Transactional
    public Coach update(Coach coach) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql("update coaches set name = :name where id = :id returning id")
                .param("name", coach.getName())
                .param("id", coach.getId())
                .update(keyHolder);

        return findById(keyHolder.getKeyAs(Long.class)).orElseThrow(
                () -> new IllegalStateException("Coach with id " + coach.getId() + " not found")
        );
    }

    @Override
    @Transactional
    public Coach delete(Long id) {
        var coach = findById(id).orElseThrow(
                () -> new IllegalStateException("Coach with id " + id + " not found")
        );

        jdbcClient
                .sql("delete from coaches where id = :id")
                .param("id", id)
                .update();

        return coach;
    }
}
