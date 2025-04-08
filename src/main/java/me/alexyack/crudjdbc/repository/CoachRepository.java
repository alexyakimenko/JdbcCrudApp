package me.alexyack.crudjdbc.repository;

import me.alexyack.crudjdbc.model.Coach;

import java.util.List;

public interface CoachRepository {
    List<Coach> findAll();
}
