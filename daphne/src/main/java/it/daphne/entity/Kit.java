package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kit")
public class Kit {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
	
	@Column(name="id_box", length=255, nullable=false, unique=false)
	private String id_box;
	
	@Column(name="id_magazzino", length=255, nullable=false, unique=false)
	private String id_magazzino;
	
	@Column(name="titolo", length=255, nullable=false, unique=false)
	private String titolo;
	
	@Column(name="quantita", length=255, nullable=false, unique=false)
	private String quantita;
	
	@Column(name="consumabile", nullable=false, unique=false)
	private Boolean consumabile;
	
	@Column(name="differenziato", nullable=false, unique=false)
	private Boolean differenziato;
	
	@Column(name="categoria1", length=1, nullable=false, unique=false)
	private String categoria1;
	
	@Column(name="categoria2", length=255, nullable=false, unique=false)
	private String categoria2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_box() {
		return id_box;
	}

	public void setId_box(String id_box) {
		this.id_box = id_box;
	}

	public String getId_magazzino() {
		return id_magazzino;
	}

	public void setId_magazzino(String id_magazzino) {
		this.id_magazzino = id_magazzino;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getQuantita() {
		return quantita;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public Boolean getConsumabile() {
		return consumabile;
	}

	public void setConsumabile(Boolean consumabile) {
		this.consumabile = consumabile;
	}

	public Boolean getDifferenziato() {
		return differenziato;
	}

	public void setDifferenziato(Boolean differenziato) {
		this.differenziato = differenziato;
	}

	public String getCategoria1() {
		return categoria1;
	}

	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}

	public String getCategoria2() {
		return categoria2;
	}

	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}
	
	
}
