package com.stok.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.stok.entity.Unit;
import com.stok.services.UnitServices;

@ViewScoped
@javax.faces.bean.ManagedBean
public class UnitEditBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject UnitServices unitServices;
	
	private Unit entity;
				
	public void save() {
		setEntity(unitServices.save(getEntity()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kaydetme baþarýlý"));
	}
	
	@PostConstruct
	public void init() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.get("p_id") != null) {
			entity = unitServices.findEntity(map.get("p_id"));
		} else
			setEntity(new Unit());
	}

	public Unit getEntity() {
		return entity;
	}

	public void setEntity(Unit unit) {
		this.entity = unit;
	}
}
