package me.alexyack.crudjdbc.controller.v1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.controller.LeagueController;
import me.alexyack.crudjdbc.dto.league.CreateLeagueDTO;
import me.alexyack.crudjdbc.dto.league.LeagueDTO;
import me.alexyack.crudjdbc.dto.league.UpdateLeagueDTO;
import me.alexyack.crudjdbc.service.LeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/leagues")
@RequiredArgsConstructor
public class LeagueControllerImpl implements LeagueController {

    private final LeagueService leagueService;

    @Override
    @GetMapping
    public List<LeagueDTO> getLeagues() {
        return leagueService.getLeagues();
    }

    @Override
    @GetMapping(path = "/{leagueId}")
    public LeagueDTO getLeagueById(
            @PathVariable Long leagueId
    ) {
        return leagueService.getLeagueById(leagueId);
    }

    @Override
    @PostMapping
    public LeagueDTO createLeague(
            @RequestBody  @Valid CreateLeagueDTO leagueDTO
    ) {
        return leagueService.createLeague(leagueDTO);
    }

    @Override
    @PutMapping(path = "/{leagueId}")
    public LeagueDTO updateLeague(
            @PathVariable Long leagueId,
            @RequestBody @Valid UpdateLeagueDTO leagueDTO
    ) {
        return leagueService.updateLeague(leagueId, leagueDTO);
    }

    @Override
    @DeleteMapping(path = "/{leagueId}")
    public LeagueDTO deleteLeague(
            @PathVariable Long leagueId
    ) {
        return leagueService.deleteLeague(leagueId);
    }
}
