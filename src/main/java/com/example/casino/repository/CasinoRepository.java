package com.example.casino.repository;

import java.util.List;

import com.example.casino.model.Player;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CasinoRepository extends CrudRepository<Player,Integer>{
    @Query(nativeQuery = true, name = "find_unique_players")
    List<Player> findByUsernameContaining(String username);
}
