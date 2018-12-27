package com.stok.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import com.stok.entity.Unit;
import com.stok.util.EntityUtil;

@ManagedBean
@ViewScoped
public class UnitBean implements Serializable {
	private static final long serialVersionUID = 1320745815695188569L;
	EntityManager em = EntityUtil.getEntityManager();
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NavigationBean getNavigationBean1() {
		return navigationBean1;
	}

	
	private Unit unit=new Unit();



	private List<Unit> unitList = new ArrayList<Unit>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void UnitList() {
		setUnitList(em.createQuery("from Unit").getResultList());

	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNavigationBean1(NavigationBean navigationBean1) {
		this.navigationBean1 = navigationBean1;
	}

	public void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Kaydetme Baþarýlý", "Kaydetme Baþarýlý"));
	}

	public void deleteMessage() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kayýt Silindi", "Kayýt Silindi"));
	}

	public void deleteMessage1() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Silinecek Kayýt Bulunamadý",
				"Silinecek Kayýt Bulunamadý"));
	}


	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void Delete1() {
		
		if (unit.getId() == null) {
			deleteMessage1();
		} 
		else{
			em.getTransaction().begin();
			em.remove(unit);
			em.getTransaction().commit();
			setUnit(new Unit());
			deleteMessage();
			UnitList();
		}
			
		
	}
	
	
public List<Unit> completeTheme1(String query) {
    	
        List<Unit> allThemes = this.getUnitList();
        List<Unit> filteredThemes = new ArrayList<Unit>();
        for (int i = 0; i < allThemes.size(); i++) {
        Unit skin = allThemes.get(i);
            if(skin.getName().toLowerCase().contains(query)) {
                filteredThemes.add(skin);    
            }
        }
         
        return filteredThemes;
       
    }
	
	
     
	public void kaydet() {

		em.getTransaction().begin();
		if (unit.getId() == null) {
			em.persist(getUnit());

		} else
			
			em.merge(unit);

		em.getTransaction().commit();
		saveMessage();
		setUnit(new Unit());
          
		UnitList();

	}
	
	public void sec(Unit unt) {

		this.unit = unt;

	}

	public String outcome() {
		return "unit";
	}

	public List<Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}



	

}
