package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.User;

public class UserDao
{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("debashish");
	
	public void saveUser(User user)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(user);
		et.commit();
	}
}
