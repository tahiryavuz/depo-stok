package com.stok.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stok.entity.DenemeIl;
import com.stok.services.DenemeIIlServis;

@ViewScoped
@javax.faces.bean.ManagedBean
public class DenemeIlListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject DenemeIIlServis denemeIIlServis;
	
	private String ad;
	private List<DenemeIl> entityList;
				
	public void ara() {
		String where = "";
		if (ad != null && !"".equals(ad)) {
			where = " where ad like '" + ad + "%'";
		}
		entityList = denemeIIlServis.ara(where);
	}
	
	@PostConstruct
	public void init() {
		ara();
	}
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<DenemeIl> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<DenemeIl> entityList) {
		this.entityList = entityList;
	}
	
}
