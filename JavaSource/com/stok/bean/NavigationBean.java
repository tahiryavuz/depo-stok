package com.stok.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = -1582423328733067301L;

	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}

	public String toLogin() {
		return "/login.xhtml";
	}

	public String redirectToInfo() {
		return "/info.xhtml?faces-redirect=true";
	}

	public String Staff() {
		return "profil";
	}

	public String toInfo() {
		return "/info.xhtml";
	}

	public String redirectToWelcome() {
		return "/xhtml/stockList.xhtml?faces-redirect=true";
	}

	public String toWelcome() {
		return "/xhtml/staff.xhtml";
	}

	public String tostaffList() {
		return "staffList.xhtml";
	}

}
