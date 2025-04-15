package me.alexyack.crudjdbc.repository;

import me.alexyack.crudjdbc.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {

    List<Team> findAll();

    Optional<Team> findById(Long id);

    Team save(Team team);

    Team update(Team team);

    Team delete(Long id);

}
