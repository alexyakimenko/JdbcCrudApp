package me.alexyack.crudjdbc.dto.team;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Team;

@Data
@Builder
public class PlayerTeamDTO {
    private Long id;
    private String name;

    public static PlayerTeamDTO from(Team team) {
        if(team == null) return null;
        return PlayerTeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }
}
