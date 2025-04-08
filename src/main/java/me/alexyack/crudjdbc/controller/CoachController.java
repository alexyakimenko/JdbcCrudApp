package me.alexyack.crudjdbc.controller;

import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.dto.coach.CreateCoachDTO;
import me.alexyack.crudjdbc.dto.coach.UpdateCoachDTO;

import java.util.List;

public interface CoachController {
    List<CoachDTO> getCoaches();

    CoachDTO getCoachById(Long id);

    CoachDTO createCoach(CreateCoachDTO coachDTO);

    CoachDTO updateCoach(Long id, UpdateCoachDTO coachDTO);

    CoachDTO deleteCoach(Long id);

}
