package me.alexyack.crudjdbc.dto.team;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Team;

@Data
@Builder
public class TeamDTO {
    private String name;

    public static TeamDTO from(Team team) {
        if (team == null) return null;
        return TeamDTO.builder()
                .name(team.getName())
                .build();
    }
}
