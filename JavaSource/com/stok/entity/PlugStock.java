package com.stok.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class PlugStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fisno;
	private Date tarih;
	private String aciklama;
	Double tutar;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private StockAction stockAction;
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFisno() {
		return fisno;
	}


	public void setFisno(String fisno) {
		this.fisno = fisno;
	}


	public Date getTarih() {
		return tarih;
	}


	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}


	public String getAciklama() {
		return aciklama;
	}


	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}


	public Double getTutar() {
		return tutar;
	}


	public void setTutar(Double tutar) {
		this.tutar = tutar;
	}


	public StockAction getStockAction() {
		return stockAction;
	}


	public void setStockAction(StockAction stockAction) {
		this.stockAction = stockAction;
	}



	
	


	

}
