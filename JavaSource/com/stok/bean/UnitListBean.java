package com.stok.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import com.stok.entity.Unit;
import com.stok.services.UnitServices;

@ViewScoped
@javax.faces.bean.ManagedBean
public class UnitListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject UnitServices unitServices;
	
	private String name;
	private List<Unit> entityList;
				
	public void ara() {
		String where = "";
		if (name != null && !"".equals(name)) {
			where = " where name like '" + name + "%'";
		}
		entityList =unitServices.ara(where);
	}
	
	public UnitServices getUnitServices() {
		return unitServices;
	}

	public void setUnitServices(UnitServices unitServices) {
		this.unitServices = unitServices;
	}

	public List<Unit> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Unit> entityList) {
		this.entityList = entityList;
	}

	@PostConstruct
	public void init() {
		ara();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
}
