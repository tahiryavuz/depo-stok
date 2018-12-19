package com.stok.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import com.stok.entity.StockGroup;
import com.stok.util.EntityUtil;

@ManagedBean
@SessionScoped
public class StcokGroupBean implements Serializable {
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
	
	

	public StockGroup getStockGroup() {
		return stockGroup;
	}

	public void setStockGroup(StockGroup stockGroup) {
		this.stockGroup = stockGroup;
	}



	private StockGroup stockGroup=new StockGroup();

	

	private List<StockGroup> stockGroupsList = new ArrayList<StockGroup>();

	private List<StockGroup> stockGroupsList1 = new ArrayList<StockGroup>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	

	public List<StockGroup> getStockGroupsList1() {
		return stockGroupsList1;
	}

	public void setStockGroupsList1(List<StockGroup> stockGroupsList1) {
		this.stockGroupsList1 = stockGroupsList1;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void StockGroupList() {
		setStockGroupsList(em.createQuery("from StockGroup where status=true").getResultList());
		setStockGroupsList1(em.createQuery("from StockGroup").getResultList());
		
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

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kayýt±t Silindi", "Kayýt Silindi"));
	}

	public void deleteMessage1() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Silinecek Kayýt Bulunamadý",
				"Silinecek Kayýt Bulunamadý"));
	}


	public void Delete1() {
		
		if (stockGroup.getId() == null) {
			deleteMessage1();
		} 
		else{
			em.getTransaction().begin();
			em.remove(stockGroup);
			em.getTransaction().commit();
			setStockGroup(new StockGroup());
			deleteMessage();
			StockGroupList();
		}
			
		
	}
     
	public void kaydet() {

		em.getTransaction().begin();
		if (stockGroup.getId() == null) {
			em.persist(getStockGroup());

		} else
			
			em.merge(stockGroup);

		em.getTransaction().commit();
		saveMessage();
		setStockGroup(new StockGroup());
          
		StockGroupList();

	}
	
	public void sec(StockGroup stc) {

		this.stockGroup = stc;

	}

	public String outcome() {
		return "stockGroup";
	}

	
	public List<StockGroup> getStockGroupsList() {
		return stockGroupsList;
	}

	public void setStockGroupsList(List<StockGroup> stockGroupsList) {
		this.stockGroupsList = stockGroupsList;
	}

}
