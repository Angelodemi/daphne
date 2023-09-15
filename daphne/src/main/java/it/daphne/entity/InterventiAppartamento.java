package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InterventiAppartamento")
public class InterventiAppartamento implements Serializable {
	@Id
	@Column(name="id_intervento", length=255, nullable=false, unique=false)
	private String id_intervento;
	
	@Id
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_appartamento;
	
	@Column(name="tipo_intervento", length=1, nullable=false, unique=false)
	private String tipo_intervento;

	public String getId_intervento() {
		return id_intervento;
	}

	public void setId_intervento(String id_intervento) {
		this.id_intervento = id_intervento;
	}

	public String getId_appartamento() {
		return id_appartamento;
	}

	public void setId_appartamento(String id_appartamento) {
		this.id_appartamento = id_appartamento;
	}

	public String getTipo_intervento() {
		return tipo_intervento;
	}

	public void setTipo_intervento(String tipo_intervento) {
		this.tipo_intervento = tipo_intervento;
	}
	
	
}
