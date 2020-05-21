package com.ak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse  res) throws IOException, ServletException 
	{
		String name=(req.getParameter("pname"));
		int power=Integer.parseInt(req.getParameter("power"));
		
		
		
		
		if(Keys.start(name, power)) {
			HttpSession session=req.getSession();
			String playerName=Keys.p.getName();
			double playerHealth=Keys.p.getHealth();
			double playerPower=Keys.p.getPower();
			session.setAttribute("playerName", playerName);
			session.setAttribute("playerHealth", playerHealth);
			session.setAttribute("playerPower", playerPower);
			RequestDispatcher r= req.getRequestDispatcher("/NewOpponent.jsp");
			r.forward(req, res);
		}
		else {
			res.sendRedirect("/");
			
		}
	}

}
