package com.diceGame.API.Repository;

import org.springframework.data.repository.CrudRepository;

import com.diceGame.API.Domain.Game;

public interface GameRepository extends CrudRepository<Game,Integer>{

}
