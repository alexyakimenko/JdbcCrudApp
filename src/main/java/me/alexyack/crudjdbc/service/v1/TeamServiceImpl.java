package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.team.CreateTeamDTO;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.dto.team.UpdateTeamDTO;
import me.alexyack.crudjdbc.repository.CoachRepository;
import me.alexyack.crudjdbc.repository.LeagueRepository;
import me.alexyack.crudjdbc.repository.PlayerRepository;
import me.alexyack.crudjdbc.repository.TeamRepository;
import me.alexyack.crudjdbc.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;
    private final LeagueRepository leagueRepository;
    private final PlayerRepository playerRepository;

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

    @Override
    public TeamDTO createTeam(CreateTeamDTO teamDTO) {

        var coach = coachRepository.findById(teamDTO.getCoachId()).orElseThrow(
                () -> new IllegalArgumentException("Coach not found")
        );
        var league = leagueRepository.findById(teamDTO.getLeagueId()).orElseThrow(
                () -> new IllegalArgumentException("League not found")
        );
        var players = playerRepository.findByIds(teamDTO.getPlayerIds());

        var team = teamRepository.save(CreateTeamDTO.toTeam(teamDTO));

        players.forEach(player -> {
            player.setTeamId(team.getId());
            playerRepository.update(player);
        });

        team.setCoach(coach);
        team.setLeague(league);
        team.setPlayers(players);

        return TeamDTO.from(team);
    }

    @Override
    public TeamDTO updateTeam(Long id, UpdateTeamDTO teamDTO) {

        var coach = coachRepository.findById(teamDTO.getCoachId()).orElseThrow(
                () -> new IllegalArgumentException("Coach not found")
        );
        var league = leagueRepository.findById(teamDTO.getLeagueId()).orElseThrow(
                () -> new IllegalArgumentException("League not found")
        );

        var oldPlayers = playerRepository.findByField("team_id", id);
        var newPlayers = playerRepository.findByIds(teamDTO.getPlayerIds());

        var team = teamRepository.update(UpdateTeamDTO.toTeam(teamDTO, id));

        oldPlayers.forEach(player -> {
            player.setTeamId(null);
            playerRepository.update(player);
        });

        newPlayers.forEach(player -> {
            player.setTeamId(team.getId());
            playerRepository.update(player);
        });

        team.setCoach(coach);
        team.setLeague(league);
        team.setPlayers(newPlayers);

        return TeamDTO.from(team);
    }
}
