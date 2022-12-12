package br.com.aa.server.participante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipanteController {
	
	@Autowired
	private ParticipanteService participanteService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/participantes")
	public List<ParticipanteEntity> getParticipantes() {
		return participanteService.getParticipantes();
	}
		
	
}
