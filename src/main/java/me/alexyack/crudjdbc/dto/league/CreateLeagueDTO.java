package me.alexyack.crudjdbc.dto.league;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.League;

@Data
@Builder
public class CreateLeagueDTO {
    private String name;

    public static League toLeague(CreateLeagueDTO createLeagueDTO) {
        return League.builder()
                .name(createLeagueDTO.getName())
                .build();
    }
}
