package me.alexyack.crudjdbc.dto.team;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.dto.league.LeagueDTO;
import me.alexyack.crudjdbc.dto.player.TeamPlayerDTO;
import me.alexyack.crudjdbc.model.Team;

import java.util.List;

@Data
@Builder
public class TeamDTO {
    private Long id;
    private String name;
    private CoachDTO coach;
    private LeagueDTO league;
    private List<TeamPlayerDTO> players;

    public static TeamDTO from(Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .coach(CoachDTO.from(team.getCoach()))
                .league(LeagueDTO.from(team.getLeague()))
                .players(team.getPlayers().stream().map(TeamPlayerDTO::from).toList())
                .build();
    }
}
