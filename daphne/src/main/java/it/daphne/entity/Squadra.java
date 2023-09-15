package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Squadra")
public class Squadra {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
	
	@Column(name="id_magazzino", length=255, nullable=false, unique=false)
	private String id_magazzino;
	
	@Column(name="city", length=255, nullable=false, unique=false)
	private String city;
	
	@Column(name="tipo", length=1, nullable=false, unique=false)
	private String tipo;
	
	@Column(name="targa_mezzo", length=7, nullable=false, unique=false)
	private String targa_mezzo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_magazzino() {
		return id_magazzino;
	}

	public void setId_magazzino(String id_magazzino) {
		this.id_magazzino = id_magazzino;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTarga_mezzo() {
		return targa_mezzo;
	}

	public void setTarga_mezzo(String targa_mezzo) {
		this.targa_mezzo = targa_mezzo;
	}
	
	
}
