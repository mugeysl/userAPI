package com.userapi.service;

import java.util.List;

import com.userapi.dto.request.CreateUserReqDto;
import com.userapi.dto.request.UpdateUserReqDto;
import com.userapi.dto.response.UserResDto;

public interface UserService {

	UserResDto createUser(CreateUserReqDto userRequest);

	UserResDto updateUser(UpdateUserReqDto userRequest) throws Exception;

	boolean deleteUser(Long userId) throws Exception;

	UserResDto findUserById(Long userId) throws Exception;

	List<UserResDto> findAllUser();

}