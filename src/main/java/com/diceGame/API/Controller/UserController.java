package com.diceGame.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diceGame.API.Domain.User;
import com.diceGame.API.Service.UserService;

@RestController
@RequestMapping(path="/players")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post method
	@PostMapping()
	public ResponseEntity<String> addUser(@RequestBody User user) {
		boolean isUserSaved = userService.savePlayer(user);
		
		if(isUserSaved) {
			return new ResponseEntity<>("status ok", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User name has been already taken", HttpStatus.CONFLICT);
		}
	}
	
	//put method
	@PutMapping(path="/{userId}")
	public void updateUser(@RequestBody User user,@PathVariable int userId) {
		userService.updateUser(user, userId);
	}
	
	//Delete players request
	 @DeleteMapping(value="/{userId}")
	 public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
		 
		 boolean isPlayerFound = userService.deteleUser(userId);
		 
		 if(isPlayerFound) {
			 return new ResponseEntity<>("User "+userId+ " has been delected Properly", HttpStatus.OK);
		 } else {
			 return new ResponseEntity<>("User was not found",HttpStatus.NOT_FOUND);
		 }
	 }
}
