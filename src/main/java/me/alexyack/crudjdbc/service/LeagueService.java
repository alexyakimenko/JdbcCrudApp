package me.alexyack.crudjdbc.service;

import me.alexyack.crudjdbc.dto.league.CreateLeagueDTO;
import me.alexyack.crudjdbc.dto.league.LeagueDTO;
import me.alexyack.crudjdbc.dto.league.UpdateLeagueDTO;

import java.util.List;

public interface LeagueService {

    List<LeagueDTO> getLeagues();

    LeagueDTO getLeagueById(Long id);

    LeagueDTO createLeague(CreateLeagueDTO leagueDTO);

    LeagueDTO updateLeague(Long id, UpdateLeagueDTO leagueDTO);

    LeagueDTO deleteLeague(Long id);

}
