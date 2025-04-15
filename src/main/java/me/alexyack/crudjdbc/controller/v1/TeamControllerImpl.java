package me.alexyack.crudjdbc.controller.v1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.controller.TeamController;
import me.alexyack.crudjdbc.dto.team.CreateTeamDTO;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/teams")
@RequiredArgsConstructor
public class TeamControllerImpl implements TeamController {

    private final TeamService teamService;

    @Override
    @GetMapping
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @Override
    @GetMapping(path = "/{teamId}")
    public TeamDTO getTeamById(
            @PathVariable Long teamId
    ) {
        return teamService.getTeamById(teamId);
    }

    @Override
    @PostMapping
    public TeamDTO createTeam(
            @RequestBody @Valid CreateTeamDTO teamDTO
    ) {
        return teamService.createTeam(teamDTO);
    }
}
