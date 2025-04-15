package me.alexyack.crudjdbc.dto.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Player;

@Data
@Builder
public class CreatePlayerDTO {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;
    @Min(value = 0, message = "Invalid id, should be equal or greater than 0")
    private Long teamId;

    public static Player toPlayer(CreatePlayerDTO playerDTO) {
        return Player.builder()
                .name(playerDTO.getName())
                .teamId(playerDTO.getTeamId())
                .build();
    }
}
