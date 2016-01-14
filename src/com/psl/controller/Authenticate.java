package com.psl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psl.bean.Users;
import com.psl.dao.GetData;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Authenticate() {
        super();
         }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GetData gd = new GetData();
		List<Users> getList = gd.getAllUsers();
		
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		for (Users users : getList) {
			if(user.equalsIgnoreCase(users.getUsername()) && pass.equalsIgnoreCase(users.getPassword()))
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				
				out.println("Invalid User");
			}
		}
	}

}
