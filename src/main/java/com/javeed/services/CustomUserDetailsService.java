package com.javeed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javeed.entities.AppUser;
import com.javeed.repos.AppUserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final AppUser appUser = appUserRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User does not exist"));
				return User.builder()
							.username(appUser.getUserName())
							.password(appUser.getPassword())
							.roles(appUser.getRole())
							.build();
	}

	
}
