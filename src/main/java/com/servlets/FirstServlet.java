package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out  = resp.getWriter();
		
		int num1 = Integer.parseInt(req.getParameter("num1")) ;
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum = num1 + num2;
		req.setAttribute("s", sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("/servlet2");
		rd.forward(req, resp);
	}
	
}
