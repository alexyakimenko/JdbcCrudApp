package me.alexyack.crudjdbc.controller;

import me.alexyack.crudjdbc.dto.coach.CoachDTO;

import java.util.List;

public interface CoachController {
    List<CoachDTO> getCoaches();
}
