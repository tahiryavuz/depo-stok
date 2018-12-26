package com.stok.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit(unitName = "StokPU")
	private	
	EntityManagerFactory factory;

	@Produces
	@Default
	@RequestScoped
	public EntityManager create() {
		return this.factory.createEntityManager();
	}
	
	public void dispose(@Disposes @Default EntityManager entityManager) {
		if (entityManager.isOpen())
			entityManager.close();
	}
	public EntityManagerFactory getFactory() {
		return factory;
	}

}
