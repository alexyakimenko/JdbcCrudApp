package me.alexyack.crudjdbc.repository.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.model.Team;
import me.alexyack.crudjdbc.repository.TeamRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepository {

    private final JdbcClient jdbcClient;

    @Override
    public List<Team> findAll() {
        return jdbcClient
                .sql("select * from teams")
                .query(Team.class)
                .list();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return jdbcClient
                .sql("select * from teams where id = :id")
                .param("id", id)
                .query(Team.class)
                .optional();
    }
}
