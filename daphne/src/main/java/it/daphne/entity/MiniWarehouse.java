package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MiniWarehouse")
public class MiniWarehouse {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
	
	@Column(name="id_warehouse", length=255, nullable=false, unique=false)
	private String id_warehouse;
	
	@Column(name="citta", length=255, nullable=false, unique=false)
	private String citta;
	
	@Column(name="via", length=255, nullable=false, unique=false)
	private String via;
	
	@Column(name="id_manager", length=255, nullable=false, unique=false)
	private String id_manager;
	
	@Column(name="num_appartamenti", nullable=false, unique=false)
	private int num_appartamenti;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_warehouse() {
		return id_warehouse;
	}

	public void setId_warehouse(String id_warehouse) {
		this.id_warehouse = id_warehouse;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getId_manager() {
		return id_manager;
	}

	public void setId_manager(String id_manager) {
		this.id_manager = id_manager;
	}

	public int getNum_appartamenti() {
		return num_appartamenti;
	}

	public void setNum_appartamenti(int num_appartamenti) {
		this.num_appartamenti = num_appartamenti;
	}
	
	
}

