package me.alexyack.crudjdbc.dto.league;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.League;

@Data
@Builder
public class CreateLeagueDTO {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    public static League toLeague(CreateLeagueDTO createLeagueDTO) {
        return League.builder()
                .name(createLeagueDTO.getName())
                .build();
    }
}
