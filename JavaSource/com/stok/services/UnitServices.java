package com.stok.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.stok.entity.Unit;

@Dependent
@Stateless
public class UnitServices implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject EntityManager em;
			
	@SuppressWarnings("unchecked")
	public List<Unit> ara(String where) {
		return em.createQuery("select u from Unit u " + where)
			.getResultList();
	}

	public Unit save(Unit entity) {
		if (entity.getId() == null)
			em.persist(entity);
		else
			em.merge(entity);
		return entity;
	}

	public Unit findEntity(String id) {
		return (Unit) em.createQuery("select u from Unit u where u.id= " + id)
				.getSingleResult();
	}
	
}
