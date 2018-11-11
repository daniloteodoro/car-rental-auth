package com.carrental.userauth.infrastructure.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.carrental.userauth.domain.LoginRepository;
import com.carrental.userauth.domain.UserInfo;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginRepositoryImpl.class);
	private final EntityManager em;

	public LoginRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean credentialsAreValid(String username, String password) {
		logger.info("Searching for user: " + username);
		TypedQuery<UserInfo> query = em.createNamedQuery(UserInfo.QUERY_USER_BY_NAME_AND_PASSWORD, UserInfo.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<UserInfo> users = query.getResultList();
		
		if (users.isEmpty()) {
			logger.info("User not found");
		}
		
		return !users.isEmpty();
	}

}








