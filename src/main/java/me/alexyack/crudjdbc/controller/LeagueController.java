package me.alexyack.crudjdbc.controller;

import me.alexyack.crudjdbc.dto.league.CreateLeagueDTO;
import me.alexyack.crudjdbc.dto.league.LeagueDTO;
import me.alexyack.crudjdbc.dto.league.UpdateLeagueDTO;

import java.util.List;

public interface LeagueController {

    List<LeagueDTO> getLeagues();

    LeagueDTO getLeagueById(Long id);

    LeagueDTO createLeague(CreateLeagueDTO leagueDTO);

    LeagueDTO updateLeague(Long leagueId, UpdateLeagueDTO leagueDTO);

    LeagueDTO deleteLeague(Long id);

}
