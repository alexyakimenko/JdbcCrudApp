package me.alexyack.crudjdbc.dto.player;

import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class TeamPlayerDTO {
    private Long id;
    private String name;

    public static TeamPlayerDTO from(Player player) {
        return TeamPlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .build();
    }
}
