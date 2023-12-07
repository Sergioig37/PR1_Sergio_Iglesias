package com.spring.start.usuarioagente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.agentes.AgenteInmobiliario;
import com.spring.start.usuario.Usuario;

@RestController
public class UsuarioAgenteController {

	
	@Autowired
	UsuarioAgenteDAO usuarioAgenteDAO;
	
	@GetMapping("/usuarios/{dni}/agentes")
	public ResponseEntity<List<AgenteInmobiliario>> getUsuariosAgentes(@PathVariable String dni){
	
		List<UsuarioAgente> usuarioAgente = (List<UsuarioAgente>) usuarioAgenteDAO.findAll();
		List<AgenteInmobiliario> agentes = null;
		
		for(UsuarioAgente usag: usuarioAgente) {
			
			if(usag.getUsuario().getDni().equals(dni)&&agentes==null) {
				agentes = new ArrayList<AgenteInmobiliario>();
				agentes.add(usag.getAgente());
			}
			else if(usag.getUsuario().getDni().equals(dni)) {
				agentes.add(usag.getAgente());
			}
		}
		
			return ResponseEntity.status(HttpStatus.OK).body(agentes);
		
	}
	
	
	
	@GetMapping("/agentes/{dni}/usuarios")
	public ResponseEntity<List<Usuario>> getAgentesUsuarios(@PathVariable String dni){
	
		List<UsuarioAgente> usuarioAgente = (List<UsuarioAgente>) usuarioAgenteDAO.findAll();
		List<Usuario> usuarios = null;
		
		for(UsuarioAgente usag: usuarioAgente) {
			
			
			if(usag.getAgente().getDni().equals(dni)&&usuarios==null) {
				usuarios = new ArrayList<Usuario>();
				usuarios.add(usag.getUsuario());
			}
			else if(usag.getAgente().getDni().equals(dni)) {
				usuarios.add(usag.getUsuario());
			}
		}
		
			return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	
	
	@DeleteMapping("/usuarios/{dniusuario}/agente/{dniagente}")
	public ResponseEntity<UsuarioAgente> getDeleteUsuariosAgentes(@PathVariable String dniusuario,
			@PathVariable String dniagente){
	
		List<UsuarioAgente> usuarioAgente = (List<UsuarioAgente>) usuarioAgenteDAO.findAll();
		
		for(UsuarioAgente usag: usuarioAgente) {
			
			
			if(usag.getAgente().getDni().equals(dniagente)&&usag.getUsuario().getDni().equals(dniusuario)) {
				usuarioAgenteDAO.delete(usag);
				return ResponseEntity.status(HttpStatus.OK).body(usag);
			}
			
		}
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		
			
	}
	
	
}
