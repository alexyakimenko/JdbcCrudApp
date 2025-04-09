package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.dto.team.PlayerTeamDTO;
import me.alexyack.crudjdbc.dto.team.TeamDTO;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class PlayerDTO {
    private Long id;
    private String name;

    private PlayerTeamDTO team;
    private PlayerStatisticsDTO statistics;

    public static PlayerDTO from(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .statistics(PlayerStatisticsDTO.from(player.getStatistics()))
                .team(PlayerTeamDTO.from(player.getTeam()))
                .build();
    }
}
