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

	@GetMapping("/findById/{id}")
	public UserDTO getUserDetailsById(@PathVariable("id") Long userId) throws Exception {
		return userService.getUserDetailsById(userId);
	}

	@PostMapping("/save")
	public UserDTO saveUserDetails(@RequestBody UserDTO userDTO) {
		return userService.saveUserDetailsById(userDTO);
	}

	// 1. create a post mapping to update the user details by using userDTO . same as /save method
	// 2. create a post mapping to delete a user details by userId . input param will be same as /findById/{id}

}
