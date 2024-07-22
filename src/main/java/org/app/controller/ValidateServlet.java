package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.app.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.model.LoginModel;
import org.app.repository.DBConfig;
import org.app.repository.DBParent;

public class ValidateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String path=request.getServletContext().getRealPath("/")+"resources\\db.properties";//current folder path
		DBParent.path=path;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginModel model=new LoginModel();
		model.setUsername(username);
		model.setPassword(password);
		ValidateUserService validateservice=new ValidateUserServiceImpl();
		model=validateservice.isValidate(model);
		if(model.getLogintype().equals("super admin"))
		{
			RequestDispatcher r=request.getRequestDispatcher("superadmin.jsp");
			r.forward(request, response);
		}
		else if(model.getLogintype().equals("employee"))
		{
			out.println("dashboard for employee");
		}
		else
		{
			out.println("invalid username and password");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
