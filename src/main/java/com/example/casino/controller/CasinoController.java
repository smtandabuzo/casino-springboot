package com.example.casino.controller;

import java.util.List;
import java.util.Optional;



import com.example.casino.model.Player;
import com.example.casino.service.CasinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/casino")
public class CasinoController {
    @Autowired 
    private CasinoService casinoService;

    //Read operation
    @GetMapping("/player/{playerId}/balance")
    public ResponseEntity<Optional<Player>> getPlayerBalance(@PathVariable("playerId")Integer playerId){
        try{
            Optional<Player> players = casinoService.fetchPlayerListById(playerId);
            if(players.isPresent()){
                return new ResponseEntity<Optional<Player>>(players,HttpStatus.FOUND);
                //return new ResponseEntity<>(players,HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
            
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    
    // Save operation
    @PostMapping("/player/{playerId}/balance/update")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
		try {
            Player _player;
            //List<Player>players = new ArrayList<Player>();
            //Double max = 0.00;
            //players.add(player);
            //for(Player indPlayer : players){
              //  if(indPlayer.getBalance() > max && indPlayer.getTransactionType() == "WAGER"){
                //    max = player.getBalance();
                  //  player.setBalance(max);
                    //_player = casinoService
					//.savePlayer(new Player(player.getPlayerId(), player.getUsername(), player.getBalance() ));
                    //if(_player.getBalance().toString() != ""){
                      //  return new ResponseEntity<>(_player, HttpStatus.BAD_REQUEST);
                    //} else {
                      //  return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                    //}
                //} else{
                  //  _player = casinoService
					//.savePlayer(new Player(player.getPlayerId(), player.getUsername(), player.getBalance()));
                    //if(_player.getBalance().toString() != ""){
                      //  return new ResponseEntity<>(_player, HttpStatus.ACCEPTED);
                    //} else {
                      //  return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                    //}
                //}
            //}

            _player = casinoService
					.savePlayer(new Player(player.getPlayerId(), player.getUsername(), player.getBalance()));
                
            
            if(_player.getBalance().toString() != ""){
                return new ResponseEntity<>(_player, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

    @PostMapping("/admin/player/transactions")
    public ResponseEntity<List<Player>> returnTransactions(@RequestBody Player player) {
        return new ResponseEntity<>(casinoService.fetchPlayerListByUsername(player.getUsername()),HttpStatus.ACCEPTED);
    }
}
