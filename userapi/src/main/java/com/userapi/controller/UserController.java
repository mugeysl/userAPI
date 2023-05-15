package com.userapi.controller;

import java.util.List;

//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapi.dto.request.CreateUserReqDto;
import com.userapi.dto.request.UpdateUserReqDto;
import com.userapi.dto.response.UserResDto;
import com.userapi.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public UserResDto createUser(@RequestBody CreateUserReqDto requestUser) {
		return userService.createUser(requestUser);
	}

	@PutMapping
	public UserResDto updateUser(@RequestBody UpdateUserReqDto requestUser) throws Exception {
		return userService.updateUser(requestUser);
	}

	@DeleteMapping("{userId}")
	public boolean deleteUser(@PathVariable("userId") Long userId) throws Exception {
		return userService.deleteUser(userId);
	}

	@GetMapping("{userId}")
	public UserResDto findUserById(@PathVariable("userId") Long userId) throws Exception {
		return userService.findUserById(userId);
	}

	@GetMapping
//	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE) 
	public List<UserResDto> findAllUser() {
		return userService.findAllUser();
	}
}