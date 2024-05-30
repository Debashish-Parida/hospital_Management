package com.org.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;


@WebServlet("/register_user")
public class UserRegister extends HttpServlet

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao=new UserDao();
		dao.saveUser(user);
		
		
	   HttpSession session = req.getSession();
	   session.setAttribute("success", "Registered Successfully");
	   
	   
	   res.sendRedirect("user_login.jsp");
	}
}
