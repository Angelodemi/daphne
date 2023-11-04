package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Box")
public class Box {
	@Id
	@Column(name="id_box", length=255, nullable=false, unique=true)
    private String id;
	
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String id_appartamento;
	
	@Column(name="id_squadra", length=255, nullable=false, unique=false)
	private String id_squadra;
	
	@Column(name="id_prenotazione", length=255, nullable=false, unique=false)
	private String id_prenotazione;

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

	public String getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(String id_squadra) {
		this.id_squadra = id_squadra;
	}

	public String getId_prenotazione() {
		return id_prenotazione;
	}

	public void setId_prenotazione(String id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}
	
	
}
