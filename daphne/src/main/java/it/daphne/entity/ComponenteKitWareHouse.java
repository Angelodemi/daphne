package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ComponenteKitWareHouse")
public class ComponenteKitWareHouse implements Serializable{
	@Id
	@Column(name="id_componente_kit", length=255, nullable=false, unique=false)
	private String id_componente_kit;
	
	@Id
	@Column(name="id_ware_house", length=255, nullable=false, unique=false)
	private String id_ware_house;
	
	@Column(name="quantita", length=255, nullable=false, unique=false)
	private String quantita;
	
	@Column(name="scaffale", length=255, nullable=false, unique=false)
	private String scaffale;

	public String getId_componente_kit() {
		return id_componente_kit;
	}

	public void setId_componente_kit(String id_componente_kit) {
		this.id_componente_kit = id_componente_kit;
	}

	public String getId_ware_house() {
		return id_ware_house;
	}

	public void setId_ware_house(String id_ware_house) {
		this.id_ware_house = id_ware_house;
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
