package com.userapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.userapi.dto.request.CreateUserReqDto;
import com.userapi.dto.request.UpdateUserReqDto;
import com.userapi.dto.response.UserResDto;
import com.userapi.entity.UserEntity;
import com.userapi.repository.UserRepository;
import com.userapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResDto createUser(CreateUserReqDto userRequest) {

		UserEntity userEntity = new UserEntity();

		userEntity.setName(userRequest.getName());
		userEntity.setSurname(userRequest.getSurname());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setPassword(userRequest.getPassword());

		UserEntity savedUserEntity = userRepository.save(userEntity);

		UserResDto userResponse = new UserResDto();

		userResponse.setUserId(savedUserEntity.getUserId());
		userResponse.setName(savedUserEntity.getName());
		userResponse.setSurname(savedUserEntity.getSurname());
		userResponse.setEmail(savedUserEntity.getEmail());

		return userResponse;
	}

	@Override
	public UserResDto updateUser(UpdateUserReqDto userRequest) throws Exception {

		Optional<UserEntity> optionalUser = userRepository.findUserById(userRequest.getUserId());

		if (!optionalUser.isPresent()) {
			throw new Exception("user not found!");
		}

		UserEntity userEntity = optionalUser.get();

		userEntity.setName(userRequest.getName());
		userEntity.setSurname(userRequest.getSurname());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setPassword(userRequest.getPassword());

		UserEntity updatedUserEntity = userRepository.save(userEntity);

		UserResDto userResponse = new UserResDto();

		userResponse.setUserId(updatedUserEntity.getUserId());
		userResponse.setName(updatedUserEntity.getName());
		userResponse.setSurname(updatedUserEntity.getSurname());
		userResponse.setEmail(updatedUserEntity.getEmail());

		return userResponse;
	}

	@Override
	public boolean deleteUser(Long userId) throws Exception {

		Optional<UserEntity> optionalUser = userRepository.findUserById(userId);

		if (!optionalUser.isPresent()) {
			throw new Exception("user not found!");
		}

		userRepository.delete(optionalUser.get());

		return true;
	}

	@Override
	public UserResDto findUserById(Long userId) throws Exception {

		Optional<UserEntity> optionalUser = userRepository.findUserById(userId);

		if (!optionalUser.isPresent()) {
			throw new Exception("user not found!");
		}

		UserEntity userEntity = optionalUser.get();

		UserResDto userResponse = new UserResDto();

		userResponse.setUserId(userEntity.getUserId());
		userResponse.setName(userEntity.getName());
		userResponse.setSurname(userEntity.getSurname());
		userResponse.setEmail(userEntity.getEmail());

		return userResponse;
	}

	@Override
	public List<UserResDto> findAllUser() {

		List<UserEntity> userEntityList = userRepository.findAllUser();

		if (userEntityList.isEmpty()) {
			return new ArrayList<>();
		}

		List<UserResDto> userResDtoList = new ArrayList<>();

		for (UserEntity userEntity : userEntityList) {
			UserResDto userResponse = new UserResDto();

			userResponse.setUserId(userEntity.getUserId());
			userResponse.setName(userEntity.getName());
			userResponse.setSurname(userEntity.getSurname());
			userResponse.setEmail(userEntity.getEmail());

			userResDtoList.add(userResponse);
		}

		return userResDtoList;
	}

}