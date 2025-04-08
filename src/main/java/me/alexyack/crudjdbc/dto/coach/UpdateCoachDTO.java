package me.alexyack.crudjdbc.dto.coach;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Coach;

@Data
@Builder
public class UpdateCoachDTO {
    private String name;

    public static Coach toCoach(UpdateCoachDTO coachDTO, Long id) {
        return Coach.builder()
                .name(coachDTO.getName())
                .id(id)
                .build();
    }
}
