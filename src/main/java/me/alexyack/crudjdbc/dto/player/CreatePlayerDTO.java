package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class CreatePlayerDTO {
    private String name;
    private Long teamId;

    public static Player toPlayer(CreatePlayerDTO playerDTO) {
        return Player.builder()
                .name(playerDTO.getName())
                .teamId(playerDTO.getTeamId())
                .build();
    }
}
