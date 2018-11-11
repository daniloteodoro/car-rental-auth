package com.carrental.userauth.infrastructure.persistence;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import com.carrental.userauth.domain.UserInfo;

@Component
public class InsertDefaultUser implements CommandLineRunner {
	
	private final JpaRepository<UserInfo, Integer> userRepository;
	
	public InsertDefaultUser(EntityManager em) {
		this.userRepository = new SimpleJpaRepository<UserInfo, Integer>(UserInfo.class, em);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//em.find(UserInfo.class, (Integer)1);
		Optional<UserInfo> u = userRepository.findById(1);
		if (!u.isPresent()) {
			UserInfo guest = new UserInfo("guest", "guest");
			userRepository.save(guest);
		}
	}

}
