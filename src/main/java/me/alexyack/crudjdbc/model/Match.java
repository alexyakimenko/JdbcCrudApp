package me.alexyack.crudjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private Long id;
    private Long homeTeamId;
    private Long awayTeamId;
    private Long matchId;
}
