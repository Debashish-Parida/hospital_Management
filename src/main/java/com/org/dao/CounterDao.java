package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CounterDao 
{
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("debashishh");
	
	
	// fetch Doctor Count
	public int fetchDoctorCount()
	{
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("Select d from Doctor d");
		
		return query.getResultList().size();
	}
	
	//fetch User Count
	public int fetchUserCount()
	{
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("Select u from User u ");
		
		return query.getResultList().size();
		
	}
	
	// fetch patient count
	
	
	// fetch specialist count
	
	
}
