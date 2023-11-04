package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class KitAppartamentoId implements Serializable{
	@Id
	@Column(name="id_kit", length=255, nullable=false, unique=true)
	private String id_kit;
	
	@Id
	@Column(name="id_appartamento", length=255, nullable=false, unique=true)
	private String id_appartamento;

	public String getId_kit() {
		return id_kit;
	}

	public void setId_kit(String id_kit) {
		this.id_kit = id_kit;
	}

	public String getId_appartamento() {
		return id_appartamento;
	}

	public void setId_appartamento(String id_appartamento) {
		this.id_appartamento = id_appartamento;
	}
}
