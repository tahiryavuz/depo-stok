package com.stok.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stok.entity.DenemeIl;

@Dependent
@Stateless
public class DenemeIIlServis implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject EntityManager em;
			
	@SuppressWarnings("unchecked")
	public List<DenemeIl> ara(String where) {
		return em.createQuery("select u from DenemeIl u " + where)
			.getResultList();
	}

	public DenemeIl kaydet(DenemeIl entity) {
		if (entity.getId() == null)
			em.persist(entity);
		else
			em.merge(entity);
		return entity;
	}

	public DenemeIl findEntity(String id) {
		return (DenemeIl) em.createQuery("select u from DenemeIl u where u.id= " + id)
				.getSingleResult();
	}
	
}
