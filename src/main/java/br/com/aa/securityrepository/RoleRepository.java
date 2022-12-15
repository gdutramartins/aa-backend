package br.com.aa.securityrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aa.security.model.RoleEntity;
import br.com.aa.security.model.RoleNameEnum;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	Optional<RoleEntity> findByName(RoleNameEnum name);
}
