package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="appartamento")
@Table(name="appartamento")
public class Appartamento {
	@Id
    private String id;
	
	@Column(name="id_warehouse", length=255, nullable=false, unique=false)
	private String id_warehouse;
	
	@Column(name="id_mini_warehouse", length=255, nullable=false, unique=false)
	private String id_mini_warehouse;
	
	@Column(name="citta", length=255, nullable=false, unique=false)
	private String citta;
	
	@Column(name="zona", length=255, nullable=false, unique=false)
	private String zona;
	
	@Column(name="indirizzo", length=255, nullable=false, unique=false)
	private String indirizzo;
	
	@Column(name="tipo_pulizia", length=1, nullable=false, unique=false)
	private String tipo_pulizia;
	
	@Column(name="num_ospiti", length=2, nullable=false, unique=false)
	private int num_ospiti;
	
	@Column(name="tipo", length=1, nullable=false, unique=false)
	private String tipo;
	
	@Column(name="stato", length=1, nullable=false, unique=false)
	private String stato;
	
	@Column(name="id_propietario", length=255, nullable=false, unique=false)
	private String id_propietario;
	
	@Column(name="metratura", length=3, nullable=false, unique=false)
	private String metratura;
	
	@Column(name="distanza", length=20, nullable=false, unique=false)
	private String distanza;
	
	@Column(name="trasporti", length=1, nullable=false, unique=false)
	private String trasporti;
	
	@Column(name="locali", length=2, nullable=false, unique=false)
	private String locali;
	
	@Column(name="bagni", length=2, nullable=false, unique=false)
	private String bagni;
	
	@Column(name="riscaldamento", length=2, nullable=false, unique=false)
	private String riscaldamento;
	
	@Column(name="ascensore",  nullable=false, unique=false)
	private Boolean ascensore;
	
	@Column(name="terrazzo", nullable=false, unique=false)
	private Boolean terrazzo;
	
	@Column(name="anno_costruzione", length=4, nullable=false, unique=false)
	private String anno_costruzione;
	
	@Column(name="classe_energetica", length=1, nullable=false, unique=false)
	private String classe_energetica;
	
	@Column(name="stato_condominio", length=255, nullable=false, unique=false)
	private String stato_condominio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_warehouse() {
		return id_warehouse;
	}

	public void setId_warehouse(String id_warehouse) {
		this.id_warehouse = id_warehouse;
	}

	public String getId_mini_warehouse() {
		return id_mini_warehouse;
	}

	public void setId_mini_warehouse(String id_mini_warehouse) {
		this.id_mini_warehouse = id_mini_warehouse;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTipo_pulizia() {
		return tipo_pulizia;
	}

	public void setTipo_pulizia(String tipo_pulizia) {
		this.tipo_pulizia = tipo_pulizia;
	}

	public int getNum_ospiti() {
		return num_ospiti;
	}

	public void setNum_ospiti(int num_ospiti) {
		this.num_ospiti = num_ospiti;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getId_propietario() {
		return id_propietario;
	}

	public void setId_propietario(String id_propietario) {
		this.id_propietario = id_propietario;
	}

	public String getMetratura() {
		return metratura;
	}

	public void setMetratura(String metratura) {
		this.metratura = metratura;
	}

	public String getDistanza() {
		return distanza;
	}

	public void setDistanza(String distanza) {
		this.distanza = distanza;
	}

	public String getTrasporti() {
		return trasporti;
	}

	public void setTrasporti(String trasporti) {
		this.trasporti = trasporti;
	}

	public String getLocali() {
		return locali;
	}

	public void setLocali(String locali) {
		this.locali = locali;
	}

	public String getBagni() {
		return bagni;
	}

	public void setBagni(String bagni) {
		this.bagni = bagni;
	}

	public String getRiscaldamento() {
		return riscaldamento;
	}

	public void setRiscaldamento(String riscaldamento) {
		this.riscaldamento = riscaldamento;
	}

	public Boolean getAscensore() {
		return ascensore;
	}

	public void setAscensore(Boolean ascensore) {
		this.ascensore = ascensore;
	}

	public Boolean getTerrazzo() {
		return terrazzo;
	}

	public void setTerrazzo(Boolean terrazzo) {
		this.terrazzo = terrazzo;
	}

	public String getAnno_costruzione() {
		return anno_costruzione;
	}

	public void setAnno_costruzione(String anno_costruzione) {
		this.anno_costruzione = anno_costruzione;
	}

	public String getClasse_energetica() {
		return classe_energetica;
	}

	public void setClasse_energetica(String classe_energetica) {
		this.classe_energetica = classe_energetica;
	}

	public String getStato_condominio() {
		return stato_condominio;
	}

	public void setStato_condominio(String stato_condominio) {
		this.stato_condominio = stato_condominio;
	}
	
	
}
