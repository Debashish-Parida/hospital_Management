package com.org.adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.User;


@WebServlet("/admin_Login")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		if(email.equals("admin@gmail.com") && "admin".equals(password))
		{
			session.setAttribute("adminObj", new User());
			res.sendRedirect("admin/admin_home.jsp");
		}
		else
		{
			session.setAttribute("failed", "Invalid Email or Password");
			res.sendRedirect("admin_login.jsp");
		}
	}
}
