package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.player.CreatePlayerDTO;
import me.alexyack.crudjdbc.dto.player.PlayerDTO;
import me.alexyack.crudjdbc.dto.player.UpdatePlayerDTO;
import me.alexyack.crudjdbc.repository.PlayerRepository;
import me.alexyack.crudjdbc.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> getPlayers() {
        return playerRepository.findAll().stream().map(PlayerDTO::from).toList();
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        var player = playerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Player not found")
        );

        return PlayerDTO.from(player);
    }

    @Override
    public PlayerDTO createPlayer(CreatePlayerDTO playerDTO) {
        var player = playerRepository.save(CreatePlayerDTO.toPlayer(playerDTO));

        return PlayerDTO.from(player);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, UpdatePlayerDTO playerDTO) {
        var player = playerRepository.update(UpdatePlayerDTO.toPlayer(playerDTO, id));
        return PlayerDTO.from(player);
    }
}
