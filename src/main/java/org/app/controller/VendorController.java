package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import org.app.model.*;
import org.app.service.VendorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendorController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		VendorModel vmodel=new VendorModel();
		String vname=request.getParameter("name");
		vmodel.setName(vname);
		VendorServiceImpl venderservice = new VendorServiceImpl();
		boolean b=venderservice.isAddNewVendor(vmodel);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("superadmin.jsp");
			r.forward(request, response);
		}
		else
		{
			out.println("<h1>Vendor not added succesfully<h1>");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
