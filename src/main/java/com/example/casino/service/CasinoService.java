package com.example.casino.service;

import java.util.List;
import java.util.Optional;

import com.example.casino.model.Player;

public interface CasinoService {
    //Save operation
    Player savePlayer(Player player);

    //Read operation
    List<Player> fetchPlayerList();

    //Read operation by id
    Optional<Player> fetchPlayerListById(Integer playerId);

    //Read operation by username
    List<Player> fetchPlayerListByUsername(String username);

    //Update operation
    Player updatePlayer(Player player, Integer playerId);

    //Delete operation
    void deletePlayerById(Integer playerId);
}
