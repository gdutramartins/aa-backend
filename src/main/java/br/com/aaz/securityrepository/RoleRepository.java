package br.com.aaz.securityrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aaz.security.model.RoleEntity;
import br.com.aaz.security.model.RoleNameEnum;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	Optional<RoleEntity> findByName(RoleNameEnum name);
}
