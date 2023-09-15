package it.daphne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InterventoManutenzione")
public class InterventoManutenzione {
	@Id
	@Column(name="id", length=255, nullable=false, unique=false)
	private String id;
	
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_appartamento;
	
	@Column(name="stato", length=1, nullable=false, unique=false)
	private String stato;
	
	@Column(name="desc_segnalazione", length=255, nullable=false, unique=false)
	private String desc_segnalazione;
	
	@Column(name="grado_gravita", length=1, nullable=false, unique=false)
	private String grado_gravita;
	
	@Column(name="grado_urgenza", length=1, nullable=false, unique=false)
	private String grado_urgenza;
	
	@Column(name="specializzazione", length=255, nullable=false, unique=false)
	private String specializzazione;
	
	@Column(name="stima_tempo", length=255, nullable=false, unique=false)
	private String stima_tempo;
	
	@Column(name="orario_segnalazione", nullable=false, unique=false)
	private Date orario_segnalazione;
	
	@Column(name="pezzi_ricambio", nullable=false, unique=false)
	private Boolean pezzi_ricambio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_appartamento() {
		return id_appartamento;
	}

	public void setId_appartamento(String id_appartamento) {
		this.id_appartamento = id_appartamento;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getDesc_segnalazione() {
		return desc_segnalazione;
	}

	public void setDesc_segnalazione(String desc_segnalazione) {
		this.desc_segnalazione = desc_segnalazione;
	}

	public String getGrado_gravita() {
		return grado_gravita;
	}

	public void setGrado_gravita(String grado_gravita) {
		this.grado_gravita = grado_gravita;
	}

	public String getGrado_urgenza() {
		return grado_urgenza;
	}

	public void setGrado_urgenza(String grado_urgenza) {
		this.grado_urgenza = grado_urgenza;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public String getStima_tempo() {
		return stima_tempo;
	}

	public void setStima_tempo(String stima_tempo) {
		this.stima_tempo = stima_tempo;
	}

	public Date getOrario_segnalazione() {
		return orario_segnalazione;
	}

	public void setOrario_segnalazione(Date orario_segnalazione) {
		this.orario_segnalazione = orario_segnalazione;
	}

	public Boolean getPezzi_ricambio() {
		return pezzi_ricambio;
	}

	public void setPezzi_ricambio(Boolean pezzi_ricambio) {
		this.pezzi_ricambio = pezzi_ricambio;
	}
	
	
	
}
