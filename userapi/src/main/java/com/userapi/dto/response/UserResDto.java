package com.userapi.dto.response;

public class UserResDto {
	private Long userId;
	private String name;
	private String surname;
	private String email;

	public UserResDto() {

	}

	public UserResDto(Long userId, String name, String surname, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}