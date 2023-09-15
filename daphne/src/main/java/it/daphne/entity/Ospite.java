package it.daphne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ospite")
public class Ospite {
	@Column(name="id_prenotazione", length=255, nullable=false, unique=false)
	private String id_prenotazione;
	
	@Column(name="nome", length=255, nullable=false, unique=false)
	private String nome;
	
	@Column(name="cognome", length=255, nullable=false, unique=false)
	private String cognome;
	
	@Column(name="data_nascita", length=8, nullable=false, unique=false)
	private Date data_nascita;
	
	@Column(name="citta_nascita", length=30, nullable=false, unique=false)
	private String citta_nascita;
	
	@Id
	@Column(name="codice_fiscale", length=16, nullable=false, unique=false)
	private String codice_fiscale;
	
	@Column(name="sesso", length=1, nullable=false, unique=false)
	private String sesso;
	
	@Column(name="nazionalita", length=20, nullable=false, unique=false)
	private String nazionalita;

	public String getId_prenotazione() {
		return id_prenotazione;
	}

	public void setId_prenotazione(String id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

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

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getCitta_nascita() {
		return citta_nascita;
	}

	public void setCitta_nascita(String citta_nascita) {
		this.citta_nascita = citta_nascita;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


	

}
