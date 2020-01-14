package com.diceGame.API.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diceGame.API.Domain.Game;
import com.diceGame.API.Repository.GameRepository;
import com.diceGame.API.Repository.UserRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean addGameDB(int userId) {
		//query
		//String sql ="SELECT * FROM USER WHERE";
		if(userRepository.existsById(userId)) {
			Game game = new Game();
			//Game game= new Game(userId);
			game.setFirstDice();
			game.setSecondDice();
			game.setIsGameWon();  
			game.setUserId(userId);
			gameRepository.save(game);
			return true;
		}else {
			return false;
		}	
	}
	
	
}
