package it.daphne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proprietario")
public class Proprietario {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

	@Column(name="nome", length=255, nullable=false, unique=false)
	private String nome;
	
	@Column(name="cognome", length=255, nullable=false, unique=false)
	private String cognome;
	
	@Column(name="data_nascita", length=8, nullable=false, unique=false)
	private Date data_nascita;
	
	@Column(name="codice_fiscale", length=16, nullable=false, unique=false)
	private String codice_fiscale;
	
	@Column(name="cellulare", length=10, nullable=false, unique=false)
	private String cellulare;
	
	@Column(name="email", length=255, nullable=false, unique=false)
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
