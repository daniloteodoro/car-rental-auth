package com.carrental.userauth.application;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.carrental.userauth.application.dto.LoginCredentials;
import com.carrental.userauth.domain.LoginRepository;
import com.carrental.userauth.domain.exceptions.InvalidUsernameOrPasswordException;
import com.carrental.userauth.domain.exceptions.UserAuthException;

@RestController
public class LoginController {
	
	private final LoginRepository loginRepository;
	
	public LoginController(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginCredentials credentials) {
		
		if (credentials == null)
			throw new UserAuthException("Invalid credentials");
		
		if (!loginRepository.credentialsAreValid(credentials.getUsername(), credentials.getPassword())) {
			throw new InvalidUsernameOrPasswordException();
		}
		
		String token = JWT.create()
                .withSubject("UserAuth")
                .withExpiresAt(new Date(System.currentTimeMillis() + 60000 ))	// 1 minute
                .sign(Algorithm.HMAC512("secret"));
        String bearer = "Bearer " + token;
		
		return ResponseEntity.ok(bearer);
	}

}
