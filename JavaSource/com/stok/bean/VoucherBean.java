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
import com.stok.entity.Voucher;
import com.stok.util.EntityUtil;

@ManagedBean
@SessionScoped
public class VoucherBean implements Serializable {
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

	private Voucher voucher = new Voucher();

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	private List<Voucher> voucherList = new ArrayList<Voucher>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void VoucherList() {
		setVoucherList(em.createQuery("from Voucher").getResultList());

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

	public void Delete1() {

		if (voucher.getId() == null) {
			deleteMessage1();
		} else {
			em.getTransaction().begin();
			em.remove(voucher);
			em.getTransaction().commit();
			setVoucher(new Voucher());
			deleteMessage();
			VoucherList();
		}

	}

	public void kaydet() {

		em.getTransaction().begin();
		if (voucher.getId() == null) {
			em.persist(getVoucher());

		} else

			em.merge(voucher);

		em.getTransaction().commit();
		saveMessage();
		setVoucher(new Voucher());

		VoucherList();

	}

	public void sec(Voucher unt) {

		this.voucher = unt;

	}

	public String outcome() {
		return "unit";
	}

	public List<Voucher> getVoucherList() {
		return voucherList;
	}

	public void setVoucherList(List<Voucher> voucherList) {
		this.voucherList = voucherList;
	}

}
