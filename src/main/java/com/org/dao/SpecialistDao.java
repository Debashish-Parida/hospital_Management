package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Specialist;

public class SpecialistDao 
{
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("debashish");
	
	public void addSpecialist(Specialist s)
	{
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public List<Specialist> fetchAllSpecialist()
	{
		EntityManager em = emf.createEntityManager();
		String jpql="Select s from Specialist s";
		
		Query query= em.createQuery(jpql);
		
		List<Specialist> list = query.getResultList();
		
		return list;
		
	}
}
