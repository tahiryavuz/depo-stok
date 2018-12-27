package com.stok.services;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import com.stok.entity.Staff;


public class StaffModel {

	@Inject EntityManager em;
	public Staff getStaff(String uname, String password) {

		try {

			Staff staff = (Staff) em
					.createQuery(
							"SELECT u from Staff u where u.uname = :uname and u.password = :password and u.Status=1")
					.setParameter("uname", uname).setParameter("password", password).getSingleResult();
			return staff;

		} catch (NoResultException e) {
			return null;

		}

	}

	public Staff getStaff1(Long id) {
		try {
			Staff staff = (Staff) em.createQuery("SELECT s from Staff s where s.id=:id").setParameter("id", id)
					.getSingleResult();
			//System.out.println(id.toString());
			return staff;
		} catch (NoResultException e) {
			return null;
		}
	}

}
