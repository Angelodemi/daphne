package it.daphne.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Arredamento")
public class Arredamento {
	@Id
    private String id;
	
	@Column(name="id_kit", length=255, nullable=false, unique=false)
	private String id_kit;
	
	@Column(name="tipo", length=255, nullable=false, unique=false)
	private String tipo;
	
	@Column(name="nome", length=255, nullable=false, unique=false)
	private String nome;
	
	@Column(name="colore", length=255, nullable=false, unique=false)
	private String colore;
	
	@Column(name="marca", length=255, nullable=false, unique=false)
	private String marca;
	
	@Column(name="descrizione", length=255, nullable=false, unique=false)
	private String descrizione;
	
	@Column(name="produttoreOnegozio", length=255, nullable=false, unique=false)
	private String produttoreOnegozio;
	
	@Column(name="misure", length=255, nullable=false, unique=false)
	private String misure;
	
	@Column(name="link_negozio", length=255, nullable=false, unique=false)
	private String link_negozio;
	
	@Column(name="foto", nullable=false, unique=false)
	private Blob foto;
	
	@Column(name="id_prodotto", length=255, nullable=false, unique=false)
	private String id_prodotto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_kit() {
		return id_kit;
	}

	public void setId_kit(String id_kit) {
		this.id_kit = id_kit;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getProduttoreOnegozio() {
		return produttoreOnegozio;
	}

	public void setProduttoreOnegozio(String produttoreOnegozio) {
		this.produttoreOnegozio = produttoreOnegozio;
	}

	public String getMisure() {
		return misure;
	}

	public void setMisure(String misure) {
		this.misure = misure;
	}

	public String getLink_negozio() {
		return link_negozio;
	}

	public void setLink_negozio(String link_negozio) {
		this.link_negozio = link_negozio;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public String getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(String id_prodotto) {
		this.id_prodotto = id_prodotto;
	}
	
}
