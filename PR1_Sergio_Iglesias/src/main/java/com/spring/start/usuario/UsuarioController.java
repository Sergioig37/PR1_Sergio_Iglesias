package com.spring.start.usuario;

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

@RestController
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		
		return ResponseEntity.status(HttpStatus.OK).body((List<Usuario>) usuarioDAO.findAll());
		
	}
	
	@GetMapping("/usuarios/{dni}")
	public ResponseEntity<Usuario> getUsuarios(@PathVariable String dni){
		
		Optional<Usuario> usuario = usuarioDAO.findById(dni);
		
		if(usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	@DeleteMapping("/usuarios/{dni}")
	public ResponseEntity<Usuario> deleteUsuarios(@PathVariable String dni){
		
		Optional<Usuario> usuario = usuarioDAO.findById(dni);
		
		if(usuario.isPresent()) {
			usuarioDAO.deleteById(dni);
			return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> postUsuarios(@RequestBody Usuario usuario){
		
		usuarioDAO.save(usuario);
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
		
	}
}
