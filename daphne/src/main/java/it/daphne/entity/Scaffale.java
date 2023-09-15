package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Scaffale")
public class Scaffale implements Serializable{
	@Id
	@Column(name="id_warehouse", length=255, nullable=false, unique=false)
	private String id_warehouse;
	
	@Id
	@Column(name="scaffale", length=255, nullable=false, unique=false)
	private String scaffale;

	public String getId_warehouse() {
		return id_warehouse;
	}

	public void setId_warehouse(String id_warehouse) {
		this.id_warehouse = id_warehouse;
	}

	public String getScaffale() {
		return scaffale;
	}

	public void setScaffale(String scaffale) {
		this.scaffale = scaffale;
	}
	
	
}
