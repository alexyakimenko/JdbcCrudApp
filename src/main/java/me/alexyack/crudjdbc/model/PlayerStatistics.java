package me.alexyack.crudjdbc.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatistics {
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer wins;
    private Integer losses;
}
