package com.ak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Move extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse  res) throws IOException, ServletException {
		
		HttpSession session=req.getSession();
		String name=req.getParameter("Action");
		if(name.equalsIgnoreCase("strike")) {
			
			if(Keys.villainSize()<2) {
				String message=Keys.villainAction(1,"",0,"");
				
				session.setAttribute("Message", message);
				RequestDispatcher r=req.getRequestDispatcher("/Actions.jsp");
				r.forward(req, res);
			}
			else {
				String message="strike";
				session.setAttribute("Message", message);
				RequestDispatcher r=req.getRequestDispatcher("/Opponent.jsp");
				r.forward(req, res);
			}
			
		}

		else if(name.equalsIgnoreCase("strikeAll")) {

			
			String message=Keys.villainActionAll(1);
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
			
			
			
		}
		
		else if(name.equalsIgnoreCase("addVillain")) {
			String message="";
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/NewOpponent.jsp");
			r.forward(req, res);
		}
		else if(name.equalsIgnoreCase("boost")) {
			String message=Keys.boostEnergy(0);
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
		}
		else if(name.equalsIgnoreCase("showvillain")) {
			String message=Keys.showList();
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
		}
		else if(name.equalsIgnoreCase("compliment")) {
			String message="Compliment";
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Compliment.jsp");
			r.forward(req, res);
		}
		else if(name.equalsIgnoreCase("showcompliment")) {
			String message="Show Compliment";
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Opponent.jsp");
			r.forward(req, res);
		}
		else if(name.equalsIgnoreCase("summary")) {
			String message=Keys.allSummary();
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
		}else if(name.equalsIgnoreCase("exit")){
			String message="";
			session.setAttribute("Message", message);
			RequestDispatcher r=req.getRequestDispatcher("/");
			r.forward(req, res);
		}
}
}
