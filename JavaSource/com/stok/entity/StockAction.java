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
@Table(name = "StockAction")
public class StockAction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date tarih;
	private String aciklama;
	private String islem_turu;
	private Double giris_miktar;
	private Double cikis_miktar;
	private Double birim_fiyat;
	private Double tutar;
	
	 
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Stock stock;
	
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIslem_turu() {
		return islem_turu;
	}
	public void setIslem_turu(String islem_turu) {
		this.islem_turu = islem_turu;
	}
	
	public Double getGiris_miktar() {
		return giris_miktar;
	}
	public void setGiris_miktar(Double giris_miktar) {
		this.giris_miktar = giris_miktar;
	}
	public Double getCikis_miktar() {
		return cikis_miktar;
	}
	public void setCikis_miktar(Double cikis_miktar) {
		this.cikis_miktar = cikis_miktar;
	}
	
	public Double getBirim_fiyat() {
		return birim_fiyat;
	}
	public void setBirim_fiyat(Double birim_fiyat) {
		this.birim_fiyat = birim_fiyat;
	}
	public Double getTutar() {
		return tutar;
	}
	public void setTutar(Double tutar) {
		this.tutar = tutar;
	}
	
	
	
	
	
	

}
