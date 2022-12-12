package br.com.aa.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findUserByUsername(String username);
}
