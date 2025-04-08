package me.alexyack.crudjdbc.dto.league;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.League;

@Data
@Builder
public class LeagueDTO {
    private Long id;
    private String name;

    public static LeagueDTO from(League league) {
        return LeagueDTO.builder()
                .id(league.getId())
                .name(league.getName())
                .build();
    }
}
