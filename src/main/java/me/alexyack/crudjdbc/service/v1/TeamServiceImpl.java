package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.repository.TeamRepository;
import me.alexyack.crudjdbc.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public List<TeamDTO> getTeams() {
        return teamRepository.findAll().stream().map(TeamDTO::from).toList();
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        var team = teamRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Team not found")
        );
        return TeamDTO.from(team);
    }
}
