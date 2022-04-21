package com.example.casino.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.casino.model.Player;
import com.example.casino.repository.CasinoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CasinoServiceImpl implements CasinoService{

    @Autowired
    private CasinoRepository casinoRepository;

    @Override
    public Player savePlayer(Player player) {
        // Save player
        return casinoRepository.save(player);
    }

    @Override
    public List<Player> fetchPlayerList() {
        // TODO Auto-generated method stub
        return (List<Player>)casinoRepository.findAll();
    }

    @Override
    public Player updatePlayer(Player player, Integer playerId) {
        // TODO Auto-generated method stub
        Player playerDB
            = casinoRepository.findById(playerId)
                  .get();
 
        if (Objects.nonNull(player.getPlayerId())
            && !"".equalsIgnoreCase(
                player.getPlayerId().toString())) {
                    playerDB.setPlayerId(
                        player.getPlayerId());
        } 
 
        if (Objects.nonNull(
            player.getBalance())
            && !"".equalsIgnoreCase(
                player.getBalance().toString())) {
                    playerDB.setBalance(
                player.getBalance());
        }
        return casinoRepository.save(playerDB);
        //return player;
    }

    @Override
    public void deletePlayerById(Integer playerId) {
        // TODO Auto-generated method stub
        casinoRepository.deleteById(playerId);
    }

    @Override
    public Optional<Player> fetchPlayerListById(Integer playerId) {
        // TODO Auto-generated method stub
        return casinoRepository.findById(playerId);
    }

    @Override
    public List<Player> fetchPlayerListByUsername(String username) {
        // TODO Auto-generated method stub
        return casinoRepository.findByUsernameContaining(username);
    }
    
}
