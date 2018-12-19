package com.stok.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cod;
	private String name;
	private Boolean status;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Unit unit1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private StockGroup group;
	
	
	
	
	  public Stock() {}

	    public Stock(Long id, String cod, String name, Boolean status) {
	        this.id = id;
	        this.cod = cod;
	        this.name = name;
	        this.status=status;
	    }
	
	
	
	
	
	public StockGroup getGroup() {
		return group;
	}

	public void setGroup(StockGroup group) {
		this.group = group;
	}

	public Unit getUnit1() {
		return unit1;
	}

	public void setUnit1(Unit unit1) {
		this.unit1 = unit1;
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	


	

}
