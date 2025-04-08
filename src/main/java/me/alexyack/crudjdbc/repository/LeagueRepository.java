package me.alexyack.crudjdbc.repository;

import me.alexyack.crudjdbc.model.League;

import java.util.List;
import java.util.Optional;

public interface LeagueRepository {

    List<League> findAll();

    Optional<League> findById(Long id);

    League save(League league);

    League update(League league);

    League delete(Long id);

}
