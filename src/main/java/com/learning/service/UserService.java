package com.learning.service;

import com.learning.dto.UserDTO;

public interface UserService {

	UserDTO getUserDetailsById(Long userId) throws Exception;

	UserDTO saveUserDetailsById(UserDTO userDTO);

}
