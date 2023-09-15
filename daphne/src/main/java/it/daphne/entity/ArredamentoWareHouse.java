package it.daphne.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ArredamentoWareHouse")
public class ArredamentoWareHouse implements Serializable{
		@Id
		@Column(name="id_prodotto", length=255, nullable=false, unique=false)
		private String id_prodotto;
		
		@Id
		@Column(name="id_ware_house", length=255, nullable=false, unique=false)
		private String id_ware_house;
		
		@Column(name="quantita", length=255, nullable=false, unique=false)
		private String quantita;
		
		@Column(name="scaffale", length=255, nullable=false, unique=false)
		private String scaffale;

		public String getId_prodotto() {
			return id_prodotto;
		}

		public void setId_prodotto(String id_prodotto) {
			this.id_prodotto = id_prodotto;
		}

		public String getId_ware_house() {
			return id_ware_house;
		}

		public void setId_ware_house(String id_ware_house) {
			this.id_ware_house = id_ware_house;
		}

		public String getQuantita() {
			return quantita;
		}

		public void setQuantita(String quantita) {
			this.quantita = quantita;
		}

		public String getScaffale() {
			return scaffale;
		}

		public void setScaffale(String scaffale) {
			this.scaffale = scaffale;
		}
		
		
}
