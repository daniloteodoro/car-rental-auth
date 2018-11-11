package com.carrental.userauth.application.dto;

public class LoginCredentials {
	
	private String username;
	private String password;
	
	
	public LoginCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return username;
	}
	
}
