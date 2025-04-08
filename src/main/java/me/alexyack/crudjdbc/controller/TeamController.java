package me.alexyack.crudjdbc.controller;

import me.alexyack.crudjdbc.dto.team.TeamDTO;

import java.util.List;

public interface TeamController {

    List<TeamDTO> getTeams();

    TeamDTO getTeamById(Long id);

}
