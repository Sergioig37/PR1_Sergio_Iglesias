package com.spring.start.usuarioagente;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.agentes.AgenteInmobiliario;
import com.spring.start.usuario.Usuario;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class UsuarioAgente {

	@EmbeddedId UsuarioAgenteKey id;
	
	
	@ManyToOne
	@MapsId("idAgente")
	@JoinColumn(name="idagente")
	@JsonBackReference
	private AgenteInmobiliario agente;
	
	
	
	@ManyToOne
	@MapsId("idUsuario")
	@JoinColumn(name="idusuario")
	@JsonBackReference
	private Usuario usuario;



	public AgenteInmobiliario getAgente() {
		return agente;
	}



	public void setAgente(AgenteInmobiliario agente) {
		this.agente = agente;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	
	
	
	
	
}
