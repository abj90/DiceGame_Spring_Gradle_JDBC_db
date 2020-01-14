package com.diceGame.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diceGame.API.Service.GameService;

@RestController
@RequestMapping(path="/players")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	//Post game
	@PostMapping("/{userId}/games")
	public ResponseEntity<String> addGame(@PathVariable int userId) {
		 
		 boolean isPlayerFound = gameService.addGameDB(userId);
		 
		 if(isPlayerFound) {
			 return new ResponseEntity<>("game was added properly",HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>("User was not found, game could not be added",HttpStatus.NOT_FOUND);
		 }
	 }

}
