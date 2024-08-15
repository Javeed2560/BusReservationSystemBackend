package com.javeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeed.entities.AppUser;
import com.javeed.entities.AuthResponseModel;
import com.javeed.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Value("${app-jwt-expiration-milliseconds}")
	private Long expiration;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseModel>login(@RequestBody AppUser appUser){
		final AuthResponseModel authResponseModel;
		final Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						appUser.getUserName(),appUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		authResponseModel = new AuthResponseModel(
							HttpStatus.OK.value(),
							"Successfully Logged in",
							token,
							System.currentTimeMillis(),
							expiration);
		return ResponseEntity.ok(authResponseModel);
	}
}
