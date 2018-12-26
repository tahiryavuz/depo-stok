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
import com.stok.entity.Stock;
import com.stok.entity.StockAction;
import com.stok.entity.StockGroup;
import com.stok.entity.Unit;
import com.stok.util.EntityUtil;



@ViewScoped
@ManagedBean(name="stockServiceList", eager = true)
public class StockListBean implements Serializable {
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

	
	public  Stock stock = new Stock();

	private StockAction stockAction = new StockAction();

	private StockGroup stockGroup = new StockGroup();

	public StockGroup getStockGroup() {
		return stockGroup;
	}

	public void setStockGroup(StockGroup stockGroup) {
		this.stockGroup = stockGroup;
	}

	private List<Stock> stockList = new ArrayList<Stock>();
	private List<Stock> stockList1 = new ArrayList<Stock>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void StockList() {
		setStockList(em.createQuery("from Stock").getResultList());
		setStockList1(em.createQuery("from Stock where status=TRUE").getResultList());

	}

	  
    public List<Stock> getStockList1() {
		return stockList1;
	}

	public void setStockList1(List<Stock> stockList1) {
		this.stockList1 = stockList1;
	}

    public List<Stock> completeTheme1(String query) {
    	
        List<Stock> allThemes = this.getStockList();
        List<Stock> filteredThemes = new ArrayList<Stock>();
        for (int i = 0; i < allThemes.size(); i++) {
        Stock skin = allThemes.get(i);
            if(skin.getName().toLowerCase().contains(query)) {
                filteredThemes.add(skin);    
            }
        }
         
        return filteredThemes;
       
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

	
	
	

	Unit unit = new Unit();

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void kaydet() {

		em.getTransaction().begin();
		if (stock.getId() == null) {
			
			em.persist(getStock());
			System.out.println("Kaydetme Baþarýlý....");
			saveMessage();

		} 
		else {

		em.merge(stock);
		saveMessage();
		System.out.println("Güncelleme Baþarýlý....");
		}
		em.getTransaction().commit();
		setStock(new Stock());
		StockList();

	}

	public void sec(Stock stk) {
		this.stock = stk;
		
	}
	

	public String outcome() {
		return "stock";
	}

	public String outcome1() {
		return "stockAction";
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public StockAction getStockAction() {
		return stockAction;
	}

	public void setStockAction(StockAction stockAction) {
		this.stockAction = stockAction;
	}

}
