package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class PlayerDTO {
    private Long id;
    private String name;

    public static PlayerDTO from(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .build();
    }
}
