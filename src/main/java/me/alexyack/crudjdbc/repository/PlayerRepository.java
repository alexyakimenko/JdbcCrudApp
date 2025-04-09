package me.alexyack.crudjdbc.repository;

import me.alexyack.crudjdbc.model.Coach;
import me.alexyack.crudjdbc.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    List<Player> findAll();

    Optional<Player> findById(Long id);

    List<Player> findByIds(List<Long> ids);

    List<Player> findByField(String field, Object value);

    Player save(Player player);

    Player update(Player player);

}
