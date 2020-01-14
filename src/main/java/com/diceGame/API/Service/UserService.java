package com.diceGame.API.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.diceGame.API.Domain.User;
import com.diceGame.API.Domain.UserRowMapper;
import com.diceGame.API.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	UserRowMapper userMapper;
	
	//save player in db
	public boolean savePlayer(User user) {
		
		if(user.getName() != "") {
			//query
			String sql = "SELECT * FROM USER WHERE NAME = ?";
			ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(
					sql, 
					new Object[]{user.getName()}, 
					new UserRowMapper());			
			
			if(users.size() == 0){
				user.setDate();
				userRepository.save(user);
				return true;
			}else {
				
				return false;
			}
			
		}else {
			
			user.setName("Anonymous");
			user.setDate();
			userRepository.save(user);
			
			return true;
		}
	}
	
	//update user in db 
	public void updateUser(User user, int userId) {
		user.setId(userId);
		userRepository.save(user);
	}
	
	// delete user in db 
	public boolean deteleUser(int userId) {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
}
