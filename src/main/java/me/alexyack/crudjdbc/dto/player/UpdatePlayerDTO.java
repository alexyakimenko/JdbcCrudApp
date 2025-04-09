package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class UpdatePlayerDTO {
    private String name;
    private Long teamId;

    public static Player toPlayer(UpdatePlayerDTO playerDTO, Long id) {
        return Player.builder()
                .id(id)
                .name(playerDTO.getName())
                .teamId(playerDTO.getTeamId())
                .build();
    }
}
