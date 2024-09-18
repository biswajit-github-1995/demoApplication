package com.learning.service;

import com.learning.dto.UserDTO;

public interface UserService {

	UserDTO getUserDetailsById(Long userId) throws Exception;

	UserDTO saveUpdateUserDetails(UserDTO userDTO);

}
