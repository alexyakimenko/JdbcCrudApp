package me.alexyack.crudjdbc.service;

import me.alexyack.crudjdbc.dto.team.TeamDTO;

import java.util.List;

public interface TeamService {

    List<TeamDTO> getTeams();

    TeamDTO getTeamById(Long id);

}
