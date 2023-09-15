package it.daphne.entity;

import java.io.Serializable;
import java.util.Date;



public class InterventoPuliziaId implements Serializable{
	private String id;
	private Date data;
	private String idAppartamento;
	
	
	public String getIdAppartamento() {
		return idAppartamento;
	}
	public void setIdAppartamento(String idAppartamento) {
		this.idAppartamento = idAppartamento;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
