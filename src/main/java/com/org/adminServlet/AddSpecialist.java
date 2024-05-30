package com.org.adminServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.Specialist;

@WebServlet("/add_specialist")
public class AddSpecialist extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		String name=req.getParameter("specName");
		
		//object of Specialist
		Specialist specialist=new Specialist();
		//set Specialist name
		specialist.setName(name);
		
		//EMF
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("debashish");
		//EM
		EntityManager em = emf.createEntityManager();
		//ET
		EntityTransaction et = em.getTransaction();
		
		///begin
		et.begin();
		//persist(specialist object)
		em.persist(specialist);
		//commit
		et.commit();
		
		HttpSession session=req.getSession();
		session.setAttribute("success", "Specialist Added");
		res.sendRedirect("admin/admin_home.jsp");
		
	}
	
	
	
}
