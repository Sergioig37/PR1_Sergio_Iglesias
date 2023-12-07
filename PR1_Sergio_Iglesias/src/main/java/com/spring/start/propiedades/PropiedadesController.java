package com.spring.start.propiedades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.usuario.Usuario;

@RestController
public class PropiedadesController {

	@Autowired
	PropiedadesDAO propiedadesDAO;
	
	@GetMapping("/propiedades")
	public ResponseEntity<List<Propiedades>> getPropiedades(){
		
		return ResponseEntity.status(HttpStatus.OK).body((List<Propiedades>) propiedadesDAO.findAll());
		
	}
	
	@GetMapping("/propiedades/{id}")
	public ResponseEntity<Propiedades> getPropiedades(@PathVariable Long id){
		
		Optional<Propiedades> propiedad = propiedadesDAO.findById(id);
		
		if(propiedad.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(propiedad.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
}
