package it.daphne.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CalendarioManutenzione")
public class CalendarioManutenzione {
	@Id
	@Column(name="id_intervento", length=255, nullable=false, unique=false)
	private String id_intervento;
	
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_squadra;
	
	@Column(name="data", nullable=false, unique=false)
	private Date Data;
	
	@Column(name="termine_avvio", nullable=false, unique=false)
	private Timestamp termineAvvio;
	
	@Column(name="termine_risoluzione", nullable=false, unique=false)
	private Timestamp termineRisoluzione;
	
	@Column(name="inizio_finestra_intervento", nullable=false, unique=false)
	private Timestamp inizioFinestraIntervento;
	
	@Column(name="fine_finestra_intervento", nullable=false, unique=false)
	private Timestamp fineFinestraIntervento;

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

	public Timestamp getTermineAvvio() {
		return termineAvvio;
	}

	public void setTermineAvvio(Timestamp termineAvvio) {
		this.termineAvvio = termineAvvio;
	}

	public Timestamp getTermineRisoluzione() {
		return termineRisoluzione;
	}

	public void setTermineRisoluzione(Timestamp termineRisoluzione) {
		this.termineRisoluzione = termineRisoluzione;
	}

	public Timestamp getInizioFinestraIntervento() {
		return inizioFinestraIntervento;
	}

	public void setInizioFinestraIntervento(Timestamp inizioFinestraIntervento) {
		this.inizioFinestraIntervento = inizioFinestraIntervento;
	}

	public Timestamp getFineFinestraIntervento() {
		return fineFinestraIntervento;
	}

	public void setFineFinestraIntervento(Timestamp fineFinestraIntervento) {
		this.fineFinestraIntervento = fineFinestraIntervento;
	}
	
	
}
