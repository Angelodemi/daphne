package it.daphne.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name="intervento_pulizia")
@Table(name="intervento_pulizia")
@IdClass(InterventoPuliziaId.class)
public class InterventoPulizia implements Serializable{
	@Id
	@Column(name="id_intervento_pulizia", length=255, nullable=false, unique=false)
	private String id;
	
	@Id
	@Column(name="id_appartamento", length=255)
	private String idAppartamento;
	
	@Column(name="id_prenotazione", length=255, nullable=false, unique=false)
	private String idPrenotazione;
	
	@Id
	@Column(name="data_intervento" , nullable=false, unique=false)
	private Date data;
	
	@Column(name="orario", length=255, nullable=false, unique=false)
	private String orario;
	
	@Column(name="num_volte_inserito", nullable=false, unique=false)
	private int numVolteInserito;
	
	@Column(name="eliminato", nullable=false, unique=false)
	private Boolean eliminato;
	
	public InterventoPulizia () {};
	public InterventoPulizia(String id, String id_appartamento, String id_prenotazione, Date data,
			int num_volte_inserito,Boolean eliminato) {
		super();
		this.id = id;
		this.idAppartamento = id_appartamento;
		this.idPrenotazione = id_prenotazione;
		this.data = data;
		this.numVolteInserito = num_volte_inserito;
		this.eliminato=eliminato;
	}

	public Boolean getEliminato() {
		return eliminato;
	}
	public void setEliminato(Boolean eliminato) {
		this.eliminato = eliminato;
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

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getIdAppartamento() {
		return idAppartamento;
	}

	public void setIdAppartamento(String idAppartamento) {
		this.idAppartamento = idAppartamento;
	}

	public String getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public int getNumVolteInserito() {
		return numVolteInserito;
	}

	public void setNumVolteInserito(int numVolteInserito) {
		this.numVolteInserito = numVolteInserito;
	}

	
	
	
}
