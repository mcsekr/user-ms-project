package in.co.practice.ms.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {

	UserDetails loadUserByUsername(String username);

}
