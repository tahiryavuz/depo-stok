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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.stok.entity.Staff;
import com.stok.services.StaffModel;


@ManagedBean
@SessionScoped
public class StaffBean implements Serializable {
	private static final long serialVersionUID = 1320745815695188569L;
	@Inject EntityManager em;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NavigationBean getNavigationBean1() {
		return navigationBean1;
	}

	private StaffModel staffModel = new StaffModel();
	private Staff staff = new Staff();



	private List<Staff> staffList = new ArrayList<Staff>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void PersonList() {
		setStaffList(em.createQuery("from Staff").getResultList());

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
		
		if (staff.getId() == null) {
			deleteMessage1();
		} 
		else{
			em.getTransaction().begin();
			em.remove(staff);
			em.getTransaction().commit();
			setStaff(new Staff());
			deleteMessage();
			PersonList();
		}
			
		
	}
     
	public void kaydet() {

		em.getTransaction().begin();
		if (staff.getId() == null) {
			em.persist(getStaff());

		} else
			
			em.merge(staff);

		em.getTransaction().commit();
		saveMessage();
		setStaff(new Staff());
          
		PersonList();

	}
	
	public void sec(Staff stf) {

		this.staff = stf;

	}

	public String outcome() {
		return "staff";
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffModel getStaffModel() {
		return staffModel;
	}

	public void setStaffModel(StaffModel staffModel) {
		this.staffModel = staffModel;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

}
