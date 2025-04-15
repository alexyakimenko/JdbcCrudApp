package me.alexyack.crudjdbc.service;

import me.alexyack.crudjdbc.dto.team.CreateTeamDTO;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.dto.team.UpdateTeamDTO;

import java.util.List;

public interface TeamService {

    List<TeamDTO> getTeams();

    TeamDTO getTeamById(Long id);

    TeamDTO createTeam(CreateTeamDTO teamDTO);

    TeamDTO updateTeam(Long id, UpdateTeamDTO teamDTO);

    TeamDTO deleteTeam(Long id);

}
