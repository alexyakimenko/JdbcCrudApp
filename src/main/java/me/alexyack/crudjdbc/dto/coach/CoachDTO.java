package me.alexyack.crudjdbc.dto.coach;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Coach;

@Data
@Builder
public class CoachDTO {
    public Long id;
    public String name;
    public Long team_id;

    public static CoachDTO from(Coach coach) {
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .team_id(coach.getTeamId())
                .build();
    }
}
