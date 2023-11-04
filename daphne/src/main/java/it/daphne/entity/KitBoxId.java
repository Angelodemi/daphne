package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class KitBoxId implements Serializable{
	@Id
	@Column(name="id_kit", length=255, nullable=false, unique=false)
	private String id_kit;
	
	@Id
	@Column(name="id_box", length=255, nullable=false, unique=false)
	private String id_box;

	public String getId_kit() {
		return id_kit;
	}

	public void setId_kit(String id_kit) {
		this.id_kit = id_kit;
	}

	public String getId_box() {
		return id_box;
	}

	public void setId_box(String id_box) {
		this.id_box = id_box;
	}
}
