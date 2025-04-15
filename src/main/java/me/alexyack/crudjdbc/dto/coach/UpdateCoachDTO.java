package me.alexyack.crudjdbc.dto.coach;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Coach;

@Data
@Builder
public class UpdateCoachDTO {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    public static Coach toCoach(UpdateCoachDTO coachDTO, Long id) {
        return Coach.builder()
                .name(coachDTO.getName())
                .id(id)
                .build();
    }
}
