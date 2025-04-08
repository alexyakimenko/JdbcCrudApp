package me.alexyack.crudjdbc.service;

import me.alexyack.crudjdbc.dto.coach.CoachDTO;

import java.util.List;

public interface CoachService {
    List<CoachDTO> getCoaches();
}
