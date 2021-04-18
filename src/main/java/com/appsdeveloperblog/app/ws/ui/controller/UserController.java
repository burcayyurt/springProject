package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.Service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserDetailsResponse;

@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser()
	{
		return "kancık simge içine alacağmış çünkü kancık";
	}
	
	@PostMapping
	public UserDetailsResponse createUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		UserDetailsResponse returnValue = new UserDetailsResponse();
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		
		BeanUtils.copyProperties(createUser,returnValue );
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser()
	{
		return "simge tribi update etti";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "simgeyi boşa";
	}

}
