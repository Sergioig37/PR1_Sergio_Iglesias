package com.spring.start.usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.agentes.AgenteInmobiliario;
import com.spring.start.inmobiliarias.Inmobiliaria;
import com.spring.start.propiedades.Propiedades;
import com.spring.start.usuarioagente.UsuarioAgente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	private String dni;
	
	
	private String nombre;
	
	@OneToMany(mappedBy="propietario", fetch = FetchType.EAGER, cascade=CascadeType.ALL )
	@Fetch(value= FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Propiedades> propiedades = new ArrayList<Propiedades>();
	
	@OneToMany(targetEntity=UsuarioAgente.class, cascade = CascadeType.ALL,
			mappedBy="usuario")
	@JsonManagedReference
	private List<AgenteInmobiliario> agentes = new ArrayList<AgenteInmobiliario>();
	
	

	public List<AgenteInmobiliario> getAgentes() {
		return agentes;
	}

	public void setAgentes(List<AgenteInmobiliario> agentes) {
		this.agentes = agentes;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Propiedades> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedades> propiedades) {
		this.propiedades = propiedades;
	}

	
	
	
	

	@Override
	public String toString() {
		return "" + dni + "" + nombre + "" + propiedades;
	}
	
	
	
	

}
