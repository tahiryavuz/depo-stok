package com.stok.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stok.entity.DenemeIl;
import com.stok.servis.DenemeIIlServis;

@ViewScoped
@javax.faces.bean.ManagedBean
public class DenemeIlEditBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject DenemeIIlServis denemeIIlServis;
	
	private DenemeIl entity;
				
	public void kaydet() {
		setEntity(denemeIIlServis.kaydet(getEntity()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kaydetme baþarýlý"));
	}
	
	@PostConstruct
	public void init() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.get("p_id") != null) {
			entity = denemeIIlServis.findEntity(map.get("p_id"));
		} else
			setEntity(new DenemeIl());
	}

	public DenemeIl getEntity() {
		return entity;
	}

	public void setEntity(DenemeIl entity) {
		this.entity = entity;
	}
}
