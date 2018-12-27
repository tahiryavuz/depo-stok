package com.stok.bean;

import java.io.Serializable;

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
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -4463307867344813038L;

	@Inject EntityManager em;
	private StaffModel staffModel = new StaffModel();
	Staff staff = new Staff();
	private boolean loggedIn;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	public String doLogin() {

		staff = staffModel.getStaff(staff.getUname(), staff.getPassword());

		if (staff != null) {

			loggedIn = true;
			return navigationBean.redirectToWelcome();

		} else {

			FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			staff = new Staff();
			return navigationBean.toLogin();

		}

	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public String doLogout() {
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return navigationBean.redirectToLogin();
	}

	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public StaffModel getStaffModel() {
		return staffModel;
	}

	public void setStaffModel(StaffModel staffModel) {
		this.staffModel = staffModel;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
