package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.UserDTO;
import com.learning.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	/**
	 * this API us being used to get the data based on the user id 
	 * @param userId
	 * @returns UserDTO and throws exception in case of no data found
	 * @throws Exception
	 */
	@GetMapping("/findById/{id}")
	public UserDTO getUserDetailsById(@PathVariable("id") Long userId) throws Exception {
		return userService.getUserDetailsById(userId);
	}

	/**
	 * this method is used to save and update the user details 
	 * @param userDTO
	 */
	@PostMapping("/save")
	public UserDTO saveUpdateUserDetails(@RequestBody UserDTO userDTO) {
		return userService.saveUpdateUserDetails(userDTO);
	}

	// 1. create a post mapping to delete a user details by userId . input param will be same as /findById/{id}

}
