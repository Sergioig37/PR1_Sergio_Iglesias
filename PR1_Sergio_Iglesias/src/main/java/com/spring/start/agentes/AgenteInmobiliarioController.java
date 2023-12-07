package com.spring.start.agentes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.inmobiliarias.Inmobiliaria;

@RestController
public class AgenteInmobiliarioController {

	@Autowired
	AgenteInmobiliarioDAO agenteDAO;
	
	
	@GetMapping("/agentes")
	public ResponseEntity<List<AgenteInmobiliario>> getAgentes(){
		
		return ResponseEntity.status(HttpStatus.OK).body((List<AgenteInmobiliario>)agenteDAO.findAll());
	}
	
	@GetMapping("/agentes/{dni}")
	public ResponseEntity<AgenteInmobiliario> getAgente(@PathVariable String dni){
		
		Optional<AgenteInmobiliario> agente = agenteDAO.findById(dni);
		
		
		if(agente.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(agente.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
}
