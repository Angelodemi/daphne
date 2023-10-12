package it.daphne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gruppo_cap")
public class GruppoCap {
	@Id
	@Column(name="id_gruppo_cap", length=255, nullable=false, unique=false)
	private String idGruppoCap;

	@Column(name="cap", length=255, nullable=false, unique=false)
	private String cap;

	public String getIdGruppoCap() {
		return idGruppoCap;
	}

	public void setIdGruppoCap(String idGruppoCap) {
		this.idGruppoCap = idGruppoCap;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	
	
	
}
