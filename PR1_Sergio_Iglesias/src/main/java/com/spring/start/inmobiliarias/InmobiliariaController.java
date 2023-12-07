package com.spring.start.inmobiliarias;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InmobiliariaController {

	@Autowired
	InmobiliariaDAO inmobiliariaDAO;
	
	@GetMapping("/inmobiliarias")
	public ResponseEntity<List<Inmobiliaria>> getInmobiliarias(){
		
		return ResponseEntity.status(HttpStatus.OK).body((List<Inmobiliaria>)inmobiliariaDAO.findAll());
	}
	
	@GetMapping("/inmobiliarias/{cif}")
	public ResponseEntity<Inmobiliaria> getInmobiliaria(@PathVariable String cif){
		Optional<Inmobiliaria> inmobiliaria = inmobiliariaDAO.findById(cif);
		
		
		if(inmobiliaria.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(inmobiliaria.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	@DeleteMapping("/inmobiliarias/{cif}")
	public ResponseEntity<Inmobiliaria> deleteInmobiliaria(@PathVariable String cif){
		
		Optional<Inmobiliaria> inmobiliariaBorrar = inmobiliariaDAO.findById(cif);
		
		if(inmobiliariaBorrar.isPresent()) {
			inmobiliariaDAO.deleteById(cif);
			return ResponseEntity.status(HttpStatus.OK).body(inmobiliariaBorrar.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(inmobiliariaBorrar.get());
		}
		
	}
	
	
	@PostMapping("/inmobiliarias")
	public ResponseEntity<Inmobiliaria> postInmobiliaria(@RequestBody Inmobiliaria inmobiliariaNueva){
		
		inmobiliariaDAO.save(inmobiliariaNueva);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(inmobiliariaNueva);
	}
	
	
}
