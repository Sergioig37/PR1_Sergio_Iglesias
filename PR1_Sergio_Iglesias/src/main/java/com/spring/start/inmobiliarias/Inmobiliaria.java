package com.spring.start.inmobiliarias;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.agentes.AgenteInmobiliario;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;

@Entity
public class Inmobiliaria {

	

	@Id
	public String cif;
	
	private String nombre;
	private int numeroEmpleados;
	
	@OneToMany(mappedBy="inmobiliaria", fetch = FetchType.EAGER, cascade=CascadeType.ALL )
	@Fetch(value= FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<AgenteInmobiliario> agentes = new ArrayList<AgenteInmobiliario>();

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public List<AgenteInmobiliario> getAgentes() {
		return agentes;
	}

	public void setAgentes(List<AgenteInmobiliario> agentes) {
		this.agentes = agentes;
	}
	@Override
	public String toString() {
		return "" + cif + "" + nombre + "" + agentes + "";
	}
	
	
	
}
