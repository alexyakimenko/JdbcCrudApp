package me.alexyack.crudjdbc.controller.v1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.controller.PlayerController;
import me.alexyack.crudjdbc.dto.player.CreatePlayerDTO;
import me.alexyack.crudjdbc.dto.player.PlayerDTO;
import me.alexyack.crudjdbc.dto.player.UpdatePlayerDTO;
import me.alexyack.crudjdbc.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/players")
@RequiredArgsConstructor
public class PlayerControllerImpl implements PlayerController {

    private final PlayerService playerService;

    @Override
    @GetMapping
    public List<PlayerDTO> getPlayers() {
        return playerService.getPlayers();
    }

    @Override
    @GetMapping(path = "/{playerId}")
    public PlayerDTO getPlayerById(
            @PathVariable Long playerId
    ) {
        return playerService.getPlayerById(playerId);
    }

    @Override
    @PostMapping
    public PlayerDTO createPlayer(
            @RequestBody @Valid CreatePlayerDTO playerDTO
    ) {
        return playerService.createPlayer(playerDTO);
    }

    @Override
    @PutMapping(path = "/{playerId}")
    public PlayerDTO updatePlayer(
            @PathVariable Long playerId,
            @RequestBody @Valid UpdatePlayerDTO playerDTO
    ) {
        return playerService.updatePlayer(playerId, playerDTO);
    }
}
