package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MezzoDiTrasporto")
public class MezzoDiTrasporto {
	@Id
	@Column(name="targa", length=255, nullable=false, unique=false)
	private String targa;
	
	@Column(name="id_squadra", length=255, nullable=false, unique=false)
	private String id_squadra;
	
	@Column(name="tipo", length=1, nullable=false, unique=false)
	private String tipo;

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(String id_squadra) {
		this.id_squadra = id_squadra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
