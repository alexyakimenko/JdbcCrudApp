package me.alexyack.crudjdbc.dto.coach;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.model.Coach;
import me.alexyack.crudjdbc.model.Team;

@Data
@Builder
public class CoachDTO {
    public Long id;
    public String name;
    public TeamDTO team;

    public static CoachDTO from(Coach coach, Team team) {
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .team(TeamDTO.from(team))
                .build();
    }
}
