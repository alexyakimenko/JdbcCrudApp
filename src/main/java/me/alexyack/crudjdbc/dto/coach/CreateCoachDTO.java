package me.alexyack.crudjdbc.dto.coach;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Coach;

@Data
@Builder
public class CreateCoachDTO {
    private String name;

    public static Coach toCoach(CreateCoachDTO coachDTO) {
        return Coach.builder()
                .name(coachDTO.getName())
                .build();
    }
}
