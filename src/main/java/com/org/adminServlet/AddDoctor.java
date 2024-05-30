package com.org.adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DoctorDao;
import com.org.dto.Doctor;

@WebServlet("/add_doctor")
public class AddDoctor extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get all the data from front end

		// set all the data in a Doctor object

		// now pass the object to DoctorDao class addDoctor()

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String spec= req.getParameter("specName");
		String qualification= req.getParameter("qualification");
		String email= req.getParameter("email");
		String mobile= req.getParameter("mobile");
		String password= req.getParameter("password");
		
		
		Doctor d = new Doctor();
		d.setDob(dob);
		d.setName(name);
		d.setSpecName(spec);
		d.setQualification(qualification);
		d.setEmail(email);
		d.setMobileNo(mobile);
		d.setPassword(password);
		
		DoctorDao dao = new DoctorDao();
		dao.addDoctor(d);
		HttpSession session = req.getSession();
		session.setAttribute("success", "Specialist Added");
		resp.sendRedirect("admin/doctor.jsp");
		
	

	}
}
