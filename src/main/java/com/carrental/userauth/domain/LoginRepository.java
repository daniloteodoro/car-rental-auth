package com.carrental.userauth.domain;

public interface LoginRepository {

	boolean credentialsAreValid(String username, String password);

}
