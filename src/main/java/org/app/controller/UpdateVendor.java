package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateVendor extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt( request.getParameter("vid"));
		String name=request.getParameter("vname");
		RequestDispatcher r=request.getRequestDispatcher("superadmin.jsp");
		r.include(request, response);	
		out.println("<input type='text' name='vendorname' +value='"+name+"'>");
		out.println("<br><br><input type='submit' name='s' +value='Update Vendor'>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
