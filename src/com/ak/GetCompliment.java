package com.ak;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCompliment extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse  res) throws IOException, ServletException {
		
			
			String compliment=req.getParameter("compliment");
			HttpSession session=req.getSession();
			session.setAttribute("compliment", compliment);
			session.setAttribute("Message", "Compliment");

			RequestDispatcher r= req.getRequestDispatcher("/Opponent.jsp");
			r.forward(req, res);
			
			
			}
}