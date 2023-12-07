package com.spring.start.propiedades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.inmobiliarias.Inmobiliaria;
import com.spring.start.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Propiedades {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	private int precio;
	private String localizacion;
	private String tipo;
	
	@JoinColumn(name="FK_PROPIETARIO")
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private Usuario propietario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "" + id + "" + precio + "" + localizacion + "" + tipo
				+ "" + propietario + "";
	}
	
	
	

}
