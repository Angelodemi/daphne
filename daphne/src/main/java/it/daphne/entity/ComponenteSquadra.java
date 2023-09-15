package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ComponenteSquadra")
public class ComponenteSquadra implements Serializable{
	
	@Id
	@Column(name="nome", length=255, nullable=false, unique=false)
	private String nome;
	
	@Id
	@Column(name="cognome", length=255, nullable=false, unique=false)
	private String cognome;
	
	@Id
	@Column(name="id_squadra", length=255, nullable=false, unique=false)
	private String id_squadra;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(String id_squadra) {
		this.id_squadra = id_squadra;
	}
	
	

}
