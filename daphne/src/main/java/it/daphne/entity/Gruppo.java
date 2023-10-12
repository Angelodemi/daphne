package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Gruppo")
public class Gruppo {

	@Id
	@Column(name="id_gruppo", length=255, nullable=false, unique=false)
	String idGruppo;
	
	@Column(name="id_squadra", length=255, nullable=false, unique=false)
	Integer idSquadra;
	
	@Column(name="cognome_componenete", length=255, nullable=false, unique=false)
	String cognomeComponente;

	public String getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}

	public Integer getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Integer idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getCognomeComponente() {
		return cognomeComponente;
	}

	public void setCognomeComponente(String cognomeComponente) {
		this.cognomeComponente = cognomeComponente;
	}
	
	
}
