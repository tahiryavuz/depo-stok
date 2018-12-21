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
import com.stok.entity.Stock;
import com.stok.entity.StockAction;
import com.stok.entity.Voucher;
import com.stok.util.EntityUtil;

@ManagedBean
@SessionScoped
public class StockActionBean implements Serializable {
	private static final long serialVersionUID = 1320745815695188569L;
	
	
	 StockBean bean=new StockBean();
	 
	 Voucher voucher=new Voucher();
	 
	 VoucherBean voucherBean=new VoucherBean();

	public VoucherBean getVoucherBean() {
		return voucherBean;
	}

	public void setVoucherBean(VoucherBean voucherBean) {
		this.voucherBean = voucherBean;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public StockBean getBean() {
		return bean;
	}

	public void setBean(StockBean bean) {
		this.bean = bean;
	}

	EntityManager em = EntityUtil.getEntityManager();
	EntityManager em1 = EntityUtil.getEntityManager();

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

	private StockAction stockAction = new StockAction();
	private Stock stock = new Stock();
	private StockBean stockBean=new StockBean();

	
	
	public StockBean getStockBean() {
		return stockBean;
	}

	public void setStockBean(StockBean stockBean) {
		this.stockBean = stockBean;
	}

	
	
	public void hesapla() {
		
	    stockAction.setTutar(this.stockAction.getBirim_fiyat()*this.stockAction.getGiris_miktar());
		System.out.println(stockAction.getGiris_miktar());
		System.out.println(stockAction.getBirim_fiyat());
	
	}
	
	  private List<StockAction> stockAction1;

	    
	    public Double getValueBuyTotal() {
	        Double quantity = 0.00;
	        for(StockAction s : stockAction1) {
	            quantity += s.getGiris_miktar();
	        }
	        return quantity;
	    }
	    
	    public Double getValueBuyTotal1() {
	        Double quantity = 0.00;
	        for(StockAction s : stockAction1) {
	            quantity += s.getTutar();
	        }
	        return quantity.doubleValue();
	    }

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	private List<StockAction> stockActionList = new ArrayList<StockAction>();

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean1;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void StockActionList() {
		setStockActionList(em.createQuery("from StockAction").getResultList());
		setStockAction1(em.createQuery("from StockAction").getResultList());
		

	}

	public List<StockAction> getStockAction1() {
		return stockAction1;
	}

	public void setStockAction1(List<StockAction> stockAction1) {
		this.stockAction1 = stockAction1;
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

		if (stockAction.getId() == null) {
			deleteMessage1();
		} else {
			em.getTransaction().begin();
			em.remove(stockAction);
			em.getTransaction().commit();
			setStockAction(new StockAction());
			deleteMessage();
			StockActionList();
		}

	}


	public void kaydet() {
		
		for(int i=0; i<=5; i++)
		{

		em.getTransaction().begin();
		if (stockAction.getId() == null || voucher.getId()==null ) {
  
			em.persist(voucher);
			
			
		
			
			em.persist(stockAction);
			
			
			System.out.println("deneme..................");
			
			
		} else
                
			em.merge(stockAction);
	
		em.getTransaction().commit();
		saveMessage();
		setStockAction(new StockAction());
		
		

		StockActionList();
		}

	}
	
	 public List<StockAction> createStock(int size) {
	        List<StockAction> list = new ArrayList<StockAction>();
	        for(int i = 0 ; i < size ; i++) {
	        	
	        	list.add(new StockAction());
	        	
	           // list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
	        }
	         
	        return list;
	    }
	
	
    
	
	 public void onAddNew() {
	        // Add one new car to the table:
		 
		 
	        StockAction car2Add = createStock(1).get(0);
	        stockAction1.add(car2Add);
	     
	    }
	
	public void sec(StockAction stk) {
		this.stockAction = stk;

	}

	public String outcome() {
		return "stockAction2";
	}

	public List<StockAction> getStockActionList() {
		return stockActionList;
	}

	public void setStockActionList(List<StockAction> stockActionList) {
		this.stockActionList = stockActionList;
	}

	public StockAction getStockAction() {
		return stockAction;
	}

	public void setStockAction(StockAction stockAction) {
		this.stockAction = stockAction;
	}

}
