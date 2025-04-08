package me.alexyack.crudjdbc.dto.coach;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Coach;

@Data
@Builder
public class CoachDTO {
    private Long id;
    public String name;

    public static CoachDTO from(Coach coach) {
        if(coach == null) return null;
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .build();
    }
}
