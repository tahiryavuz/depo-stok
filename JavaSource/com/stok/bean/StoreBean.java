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
import com.stok.entity.Store;
import com.stok.util.EntityUtil;

@ManagedBean
@SessionScoped
public class StoreBean implements Serializable {
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

	private Store store=new Store();



	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	private List<Store> storeList = new ArrayList<Store>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void StoreList() {
		setStoreList(em.createQuery("from Store").getResultList());

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
		
		if (store.getId() == null) {
			deleteMessage1();
		} 
		else{
			em.getTransaction().begin();
			em.remove(store);
			em.getTransaction().commit();
			setStore(new Store());
			deleteMessage();
			StoreList();
		}
			
		
	}
     
	public void kaydet() {

		em.getTransaction().begin();
		if (store.getId() == null) {
			em.persist(getStore());

		} else
			
			em.merge(store);

		em.getTransaction().commit();
		saveMessage();
		setStore(new Store());
          
		StoreList();

	}
	
	public void sec(Store str) {

		this.store = str;

	}

	public String outcome() {
		return "store";
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

}
