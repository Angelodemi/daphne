package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KitComponenteKit")
public class KitComponenteKit implements Serializable{
	@Id
	@Column(name="id_kit", length=255, nullable=false, unique=false)
	private String id_kit;
	
	@Id
	@Column(name="id_componente_kit", length=255, nullable=false, unique=false)
	private String id_componente_kit;
	
	@Column(name="quantita", length=255, nullable=false, unique=false)
	private String quantita;
	
	@Column(name="scaffale", length=255, nullable=false, unique=false)
	private String scaffale;

	public String getId_kit() {
		return id_kit;
	}

	public void setId_kit(String id_kit) {
		this.id_kit = id_kit;
	}

	public String getId_componente_kit() {
		return id_componente_kit;
	}

	public void setId_componente_kit(String id_componente_kit) {
		this.id_componente_kit = id_componente_kit;
	}

	public String getQuantita() {
		return quantita;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public String getScaffale() {
		return scaffale;
	}

	public void setScaffale(String scaffale) {
		this.scaffale = scaffale;
	}
	
	
}

