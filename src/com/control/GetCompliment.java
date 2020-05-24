package com.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCompliment extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		Enumeration<String> en = req.getParameterNames();
		HttpSession session = req.getSession(false);
		if (session == null) {
			System.out.println("null");
			res.sendRedirect("/DemoApp/");
		}

		else if (session != null) {

			if (en.hasMoreElements()) {

				String compliment = req.getParameter("compliment");
				if (compliment == null)
					res.sendRedirect("/DemoApp/");

				session.setAttribute("compliment", compliment);
				session.setAttribute("Message", "Compliment");

				RequestDispatcher r = req.getRequestDispatcher("/Opponent.jsp");
				r.forward(req, res);

			} else {
				RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
				r.forward(req, res);

			}
		}
	}
}