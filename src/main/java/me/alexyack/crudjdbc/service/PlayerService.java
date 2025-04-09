package me.alexyack.crudjdbc.service;

import me.alexyack.crudjdbc.dto.player.CreatePlayerDTO;
import me.alexyack.crudjdbc.dto.player.PlayerDTO;
import me.alexyack.crudjdbc.dto.player.UpdatePlayerDTO;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO> getPlayers();

    PlayerDTO getPlayerById(Long id);

    PlayerDTO createPlayer(CreatePlayerDTO playerDTO);

    PlayerDTO updatePlayer(Long id, UpdatePlayerDTO playerDTO);
}
