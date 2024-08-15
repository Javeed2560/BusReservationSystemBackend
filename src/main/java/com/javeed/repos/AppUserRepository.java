package com.javeed.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeed.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	Optional<AppUser> findByUserName(String userName);

}
