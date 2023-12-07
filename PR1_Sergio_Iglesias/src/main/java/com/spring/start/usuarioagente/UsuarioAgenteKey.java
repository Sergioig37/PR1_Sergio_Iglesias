package com.spring.start.usuarioagente;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioAgenteKey  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String idUsuario;
	
	@Column
	private String idAgente;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAgente, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioAgenteKey other = (UsuarioAgenteKey) obj;
		return Objects.equals(idAgente, other.idAgente) && Objects.equals(idUsuario, other.idUsuario);
	}
	
	
	
	
	
	

	
}
