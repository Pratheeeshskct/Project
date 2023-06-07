package org.libre.com.service;

import java.util.Optional;

import org.libre.com.dto.LoginDto;
import org.libre.com.model.UserModel;
import org.libre.com.payload.LoginMessage;
import org.libre.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	public UserRepository repo;
	
	public LoginMessage loginUser(LoginDto data) {
		UserModel user1 = repo.findByEmail(data.getEmail());
		
		if(user1 != null) {
			Optional<UserModel> details = repo.findOneByEmailAndPassword(data.getEmail(), data.getPassword());
			
			if(details.isPresent()) {
				return new LoginMessage("Password is correct", true);
			}
			else {
				return new LoginMessage("Password is incorrect", false);
			}
		}
		else {
			return new LoginMessage("Email does not exist", false);
		}
	}
}
