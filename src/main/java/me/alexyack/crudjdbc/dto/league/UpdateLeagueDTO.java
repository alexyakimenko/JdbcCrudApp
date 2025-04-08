package me.alexyack.crudjdbc.dto.league;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.League;

@Data
@Builder
public class UpdateLeagueDTO {
    private String name;

    public static League toLeague(UpdateLeagueDTO leagueDTO, Long id) {
        return League.builder()
                .id(id)
                .name(leagueDTO.getName())
                .build();
    }
}
