package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KitWareHouse")
public class KitWareHouse implements Serializable{
	@Id
	@Column(name="id_kit", length=255, nullable=false, unique=false)
	private String id_kit;
	
	@Id
	@Column(name="id_ware_house", length=255, nullable=false, unique=false)
	private String id_ware_house;
	
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
