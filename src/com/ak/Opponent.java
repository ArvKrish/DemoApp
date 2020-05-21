package com.ak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Opponent extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse  res) throws IOException, ServletException {
		String name=(req.getParameter("oname"));
		int key=Integer.parseInt(req.getParameter("key"));
		
	
		
		boolean check=Keys.newVillain(name, key); 

		HttpSession session=req.getSession();
		if(check)
			session.setAttribute("Message", "New Villain added");
		else
			session.setAttribute("Message", "Duplicate code. Try again!");
		session.setAttribute("villainSize", Keys.villainSize());
		RequestDispatcher r= req.getRequestDispatcher("/Actions.jsp");
		r.forward(req, res);
		}
	}

