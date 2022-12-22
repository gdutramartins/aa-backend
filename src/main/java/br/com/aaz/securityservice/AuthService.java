package br.com.aaz.securityservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.aaz.exception.AppException;
import br.com.aaz.security.dto.LoginRequestDTO;
import br.com.aaz.security.dto.SignupRequestDTO;
import br.com.aaz.security.model.RoleEntity;
import br.com.aaz.security.model.RoleNameEnum;
import br.com.aaz.security.model.UserEntity;
import br.com.aaz.securityrepository.RoleRepository;
import br.com.aaz.securityrepository.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	public Authentication authenticate(LoginRequestDTO loginRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password));
		
		return authentication;
	}
	
	@Transactional
	public void criaUsuario(SignupRequestDTO signUpRequest) {
		if (StringUtils.isEmpty(signUpRequest.username) || StringUtils.isEmpty(signUpRequest.password)
				|| StringUtils.isEmpty(signUpRequest.nome)) {
			throw new AppException("Campos e-mail, nome e senha são obrigatórios");
		}

		if (userRepository.existsByUsername(signUpRequest.username)) {
			throw new AppException("Usuário com o e-mail informado já está cadastrado");
		}

		// Create new user's account
		UserEntity user = new UserEntity(signUpRequest.username, signUpRequest.nome,
				encoder.encode(signUpRequest.password));

		Set<RoleEntity> roles = new HashSet<>();
		RoleEntity userRole = roleRepository.findByName(RoleNameEnum.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);
		userRepository.save(user);
	}
}
