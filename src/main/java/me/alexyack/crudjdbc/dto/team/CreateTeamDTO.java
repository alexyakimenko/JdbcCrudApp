package me.alexyack.crudjdbc.dto.team;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.dto.player.PlayerDTO;
import me.alexyack.crudjdbc.model.Team;

import java.util.List;

@Data
@Builder
public class CreateTeamDTO {
    private String name;
    private Long coachId;
    private Long leagueId;
    private List<Long> playerIds;

    public static Team toTeam(CreateTeamDTO teamDTO) {
        return Team.builder()
                .name(teamDTO.getName())
                .coachId(teamDTO.getCoachId())
                .leagueId(teamDTO.getLeagueId())
                .build();
    }
}
