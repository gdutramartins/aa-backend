package br.com.aa.server.participante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	
	public List<ParticipanteEntity> getParticipantes() {
		return participanteRepository.findAll();
	}
}
