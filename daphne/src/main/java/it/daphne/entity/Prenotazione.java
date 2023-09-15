package it.daphne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Prenotazione")
public class Prenotazione implements Comparable<Prenotazione>{
	@Id
    private String id;
		
	@Column(name="id_appartamento", length=255, nullable=false, unique=false)
	private String idAppartamento;
	
	@Column(name="data_check_in",  nullable=false, unique=false)
	private Date dataCheckIn;
	
	@Column(name="data_check_out",  nullable=false, unique=false)
	private Date dataCheckOut;
	
	@Column(name="num_ospiti",  nullable=false, unique=false)
	private int numOspiti;
	
	
	public Prenotazione() {}
	
	public Prenotazione(String id, String idAppartamento, Date dataCheckIn, Date dataCheckOut, int numOspiti) {
		super();
		this.id = id;
		this.idAppartamento = idAppartamento;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.numOspiti = numOspiti;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdAppartamento() {
		return idAppartamento;
	}

	public void setIdAppartamento(String idAppartamento) {
		this.idAppartamento = idAppartamento;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public int getNumOspiti() {
		return numOspiti;
	}

	public void setNumOspiti(int numOspiti) {
		this.numOspiti = numOspiti;
	}



	@Override
	public int compareTo(Prenotazione o) {
		// TODO Auto-generated method stub
		return dataCheckOut.compareTo(o.getDataCheckOut());
	}

	
}
