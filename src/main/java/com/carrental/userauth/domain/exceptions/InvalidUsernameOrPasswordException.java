package com.carrental.userauth.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidUsernameOrPasswordException extends UserAuthException {

	private static final long serialVersionUID = 2575057858397294183L;

	public InvalidUsernameOrPasswordException() {
		super("Invalid username or password");
	}

	public InvalidUsernameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUsernameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUsernameOrPasswordException(String message) {
		super(message);
	}

	public InvalidUsernameOrPasswordException(Throwable cause) {
		super(cause);
	}
	
}
