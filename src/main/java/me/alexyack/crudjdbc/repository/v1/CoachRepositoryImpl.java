package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Coach;
import me.alexyack.crudjdbc.repository.CoachRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
