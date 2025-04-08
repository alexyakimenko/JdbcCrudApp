package me.alexyack.crudjdbc.repository;

import me.alexyack.crudjdbc.model.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachRepository {

    List<Coach> findAll();

    Optional<Coach> findById(Long id);

    List<Coach> findByField(String field, Object value);

    Coach save(Coach coach);

    Coach update(Coach coach);

    Coach delete(Long id);

}
