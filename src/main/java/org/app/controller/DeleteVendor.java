package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.model.VendorModel;
import org.app.service.*;

public class DeleteVendor extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt( request.getParameter("vid"));
		VendorService vservice=new VendorServiceImpl();
		boolean b=vservice.isDeleteVendor(id);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("superadmin.jsp");
			r.include(request, response);
			out.println("<h1>Vendor deleted succesfully</h1>");
		}
		else
		{
			out.println("Vendor not deleted");
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
