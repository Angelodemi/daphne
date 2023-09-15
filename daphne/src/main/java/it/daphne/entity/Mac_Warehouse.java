package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mac_Warehouse")
public class Mac_Warehouse implements Serializable{
	@Id
	@Column(name="id_macchinario", length=255, nullable=false, unique=false)
	private String id_macchinario;
	
	@Id
	@Column(name="id_warehouse", length=255, nullable=false, unique=false)
	private String id_warehouse;
	

	@Column(name="quantita", nullable=false, unique=false)
	private int quantita;


	public String getId_macchinario() {
		return id_macchinario;
	}


	public void setId_macchinario(String id_macchinario) {
		this.id_macchinario = id_macchinario;
	}


	public String getId_warehouse() {
		return id_warehouse;
	}


	public void setId_warehouse(String id_warehouse) {
		this.id_warehouse = id_warehouse;
	}


	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	 

}
