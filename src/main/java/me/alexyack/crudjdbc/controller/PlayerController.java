package me.alexyack.crudjdbc.controller;

import me.alexyack.crudjdbc.dto.player.CreatePlayerDTO;
import me.alexyack.crudjdbc.dto.player.PlayerDTO;
import me.alexyack.crudjdbc.dto.player.UpdatePlayerDTO;

import java.util.List;

public interface PlayerController {

    List<PlayerDTO> getPlayers();

    PlayerDTO getPlayerById(Long id);

    PlayerDTO createPlayer(CreatePlayerDTO playerDTO);

    PlayerDTO updatePlayer(Long id, UpdatePlayerDTO playerDTO);

}
