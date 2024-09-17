package com.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.UserDTO;
import com.learning.model.User;
import com.learning.repository.UserRepository;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO getUserDetailsById(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
			return new UserDTO(user.get());
		else
			throw new Exception("User Details Not Found");
	}

	@Override
	public UserDTO saveUserDetailsById(UserDTO userDTO) {
		User user = new User(userDTO);
		user = userRepository.save(user);
		user = userRepository.findById(user.getUserId()).get();
		return new UserDTO(user);
	}

}
