package br.com.aaz.securityrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aaz.security.model.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);
	
	 Boolean existsByUsername(String username);
}
