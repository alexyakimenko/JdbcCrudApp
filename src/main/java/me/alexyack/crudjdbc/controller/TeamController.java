package me.alexyack.crudjdbc.controller;

import jakarta.validation.Valid;
import me.alexyack.crudjdbc.dto.team.CreateTeamDTO;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.dto.team.UpdateTeamDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/teams")
public interface TeamController {

    @GetMapping
    List<TeamDTO> getTeams();

    @GetMapping(path = "/{teamId}")
    TeamDTO getTeamById(@PathVariable Long teamId);

    @PostMapping
    TeamDTO createTeam(@RequestBody @Valid CreateTeamDTO teamDTO);

    @PutMapping(path = "/{teamId}")
    TeamDTO updateTeam(@PathVariable Long teamId, @RequestBody @Valid UpdateTeamDTO teamDTO);

}
