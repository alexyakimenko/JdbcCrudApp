package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.league.CreateLeagueDTO;
import me.alexyack.crudjdbc.dto.league.LeagueDTO;
import me.alexyack.crudjdbc.dto.league.UpdateLeagueDTO;
import me.alexyack.crudjdbc.repository.LeagueRepository;
import me.alexyack.crudjdbc.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    @Override
    public List<LeagueDTO> getLeagues() {
        return leagueRepository.findAll().stream().map(LeagueDTO::from).toList();
    }

    @Override
    public LeagueDTO getLeagueById(Long id) {
        var league = leagueRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("League not found")
        );
        return LeagueDTO.from(league);
    }

    @Override
    public LeagueDTO createLeague(CreateLeagueDTO leagueDTO) {
        var league = leagueRepository.save(CreateLeagueDTO.toLeague(leagueDTO));
        return LeagueDTO.from(league);
    }

    @Override
    public LeagueDTO updateLeague(Long id, UpdateLeagueDTO leagueDTO) {
        var league = leagueRepository.update(UpdateLeagueDTO.toLeague(leagueDTO, id));
        return LeagueDTO.from(league);
    }

    @Override
    public LeagueDTO deleteLeague(Long id) {
        var league = leagueRepository.delete(id);
        return LeagueDTO.from(league);
    }
}
