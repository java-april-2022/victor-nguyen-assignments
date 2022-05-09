package com.victor.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.victor.bookclub.models.LoginUser;
import com.victor.bookclub.models.User;
import com.victor.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
 
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email","Matches", "An account with that email already exists!");
    	}
    	
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The passwords must match!");
    	}
    	
    	if (result.hasErrors()) {
    		return null;
    	}
    	
        String hashpass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashpass);
        return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	User user = potentialUser.get();
    	
    	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Not a valid password!");
    	}
    	
    	if (result.hasErrors()) {    		
    		return null;
    	}
    	
    	else {
    		return user;
    	}
    }
	
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	
    	if (potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	else {
    		return null;
    	}
    }
    
    public User findByEmail(String email) {
    	
    	Optional<User> result = userRepo.findByEmail(email);
    	
    	if (result.isPresent()) {
    		return result.get();
    	}
    	else {
    		return null;
    	}
    	
    }
}
