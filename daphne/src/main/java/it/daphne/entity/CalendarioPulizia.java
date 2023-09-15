package it.daphne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CalendarioPulizia")
public class CalendarioPulizia {
	@Id
	@Column(name="id_intervento", length=255, nullable=false, unique=false)
	private String id_intervento;
	
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_squadra;
	
	@Column(name="data", nullable=false, unique=false)
	private Date Data;

	public String getId_intervento() {
		return id_intervento;
	}

	public void setId_intervento(String id_intervento) {
		this.id_intervento = id_intervento;
	}

	public String getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(String id_squadra) {
		this.id_squadra = id_squadra;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
	
	
}
