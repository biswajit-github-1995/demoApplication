package com.learning.service.impl;

import java.util.Date;
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
	
	/**
	 * get user details by userID
	 */
	@Override
	public UserDTO getUserDetailsById(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
			return new UserDTO(user.get());
		else
			throw new Exception("User Details Not Found");
	}

	/**
	 * save and update user details by userDTO
	 */
	@Override
	public UserDTO saveUpdateUserDetails(UserDTO userDTO) {
		try {
			User user;
			if(userDTO.getUserId() != null) {
				user = userRepository.findById(userDTO.getUserId()).get();
			}else {
				user = new User();
				user.setUserName(userDTO.getUserName());
				user.setCreatedOn(new Date());
				user.setCreatedBy("ADMIN");
			}
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			user.setEmail(userDTO.getEmail());
			user.setPhoneNo(userDTO.getPhoneNo());
			user.setUpdatedBy("ADMIN");
			user.setUpdatedOn(new Date());
			user = userRepository.save(user);
			return new UserDTO(user);
		}catch(Exception e) {
			e.printStackTrace();
			return new UserDTO();
		}
	}

}
