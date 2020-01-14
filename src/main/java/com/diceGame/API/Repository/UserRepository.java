package com.diceGame.API.Repository;



import org.springframework.data.repository.CrudRepository;

import com.diceGame.API.Domain.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	
}
