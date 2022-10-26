package com.jpa.course1.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jpa.course1.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user);
	UserDto getUser(String email);
}
