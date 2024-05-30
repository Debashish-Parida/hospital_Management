package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Doctor;

public class DoctorDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("debashish");

	public void addDoctor(Doctor d) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(d);
		et.commit();

	}
	
	public List<Doctor> fetchAllDoctors() {
		EntityManager em = emf.createEntityManager();
		String jpql = "select s from Doctor s";

		Query query = em.createQuery(jpql);

		List<Doctor> list = query.getResultList();
		return list;
	}
}
