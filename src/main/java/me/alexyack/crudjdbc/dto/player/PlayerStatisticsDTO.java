package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.PlayerStatistics;

@Data
@Builder
public class PlayerStatisticsDTO {
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer wins;
    private Integer losses;

    public static PlayerStatisticsDTO from(PlayerStatistics statistics) {
        if (statistics == null) return null;
        return PlayerStatisticsDTO.builder()
                .kills(statistics.getKills())
                .deaths(statistics.getDeaths())
                .assists(statistics.getAssists())
                .wins(statistics.getWins())
                .losses(statistics.getLosses())
                .build();
    }
}
