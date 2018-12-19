package com.stok.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Unit")
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String ksname;
	private Long Status;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKsname() {
		return ksname;
	}
	public void setKsname(String ksname) {
		this.ksname = ksname;
	}
	public Long getStatus() {
		return Status;
	}
	public void setStatus(Long status) {
		Status = status;
	}
	
	
	
	

	

	

}
