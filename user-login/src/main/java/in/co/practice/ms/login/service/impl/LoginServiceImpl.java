package in.co.practice.ms.login.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import in.co.practice.ms.login.entity.LoginEntity;
import in.co.practice.ms.login.repo.LoginRepo;
import in.co.practice.ms.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<LoginEntity> entity =  loginRepo.findById(username);
		
		LoginEntity user = entity.get();
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

	

}
