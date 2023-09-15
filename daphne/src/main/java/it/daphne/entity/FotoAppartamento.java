package it.daphne.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FotoAppartamento")
public class FotoAppartamento implements Serializable {
	@Id
	@Column(name="id_foto", length=255, nullable=false, unique=false)
	private String id_foto;
	
	@Id
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_appartamento;
	
	@Column(name="foto", nullable=false, unique=false)
	private Blob foto;

	public String getId_foto() {
		return id_foto;
	}

	public void setId_foto(String id_foto) {
		this.id_foto = id_foto;
	}

	public String getId_appartamento() {
		return id_appartamento;
	}

	public void setId_appartamento(String id_appartamento) {
		this.id_appartamento = id_appartamento;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	
}
