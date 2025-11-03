package in.co.practice.ms.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.practice.ms.login.dto.LoginDto;
import in.co.practice.ms.login.exceptions.DuplicateEmployeePresent;
import in.co.practice.ms.login.security.JwtUtils;
import in.co.practice.ms.login.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<Object> saveEmployee(@RequestBody LoginDto dto) throws DuplicateEmployeePresent {


		if (dto == null || dto.getEmail() == null || dto.getEmail().length() < 6 || dto.getPassword() == null
				|| dto.getPassword().length() <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid user data");
		}
		System.out.println(dto);
		System.out.println(authenticationManager);
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		//authenticationManager.authenticate(null);
		System.out.println(auth);
		if(auth.isAuthenticated()) {
			// generate JWT token
			UserDetails userDetails = service.loadUserByUsername(dto.getEmail());
			String token = jwtUtils.generateToken(userDetails);
			System.out.println(token);
			Map<String, String> response = new HashMap<String, String>();
			response.put("access_token", token);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login failed");

	
	}

	

}
