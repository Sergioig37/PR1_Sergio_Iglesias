package com.spring.start.agentes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.inmobiliarias.Inmobiliaria;
import com.spring.start.usuario.Usuario;
import com.spring.start.usuarioagente.UsuarioAgente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AgenteInmobiliario {

	@Id
	private String dni;
	
	
	private String nombre;
	private String telefonoContacto;
	
	@JoinColumn(name="FK_INMOBILIARIA")
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private Inmobiliaria inmobiliaria;
	
	
	@OneToMany(targetEntity=UsuarioAgente.class, cascade = CascadeType.ALL,
			mappedBy="agente")
	@JsonManagedReference
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "" + dni + ";" + nombre + ";" + inmobiliaria
				+";" + telefonoContacto ;
	}

	
	
	
}
