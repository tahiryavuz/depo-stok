package com.stok.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DenemeIlce implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private DenemeIl denemeIl;
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public DenemeIl getDenemeIl() {
		return denemeIl;
	}
	public void setDenemeIl(DenemeIl denemeIl) {
		this.denemeIl = denemeIl;
	}
}
