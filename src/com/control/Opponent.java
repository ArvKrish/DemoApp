package com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ak.Keys;

public class Opponent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session = req.getSession(false);
		if (session == null) {
			res.sendRedirect("/DemoApp/");
		}
		int uKey = (int) (session.getAttribute("uKey"));
		String name = (req.getParameter("oname"));
		int key = Integer.parseInt(req.getParameter("key"));
		boolean check = Keys.newVillain(uKey, name, key);

		if (check)
			session.setAttribute("Message", "New Villain added");
		else
			session.setAttribute("Message", "Duplicate code. Try again!");
		session.setAttribute("villainSize", Keys.villainSize(uKey));
		RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
		r.forward(req, res);
	}
}
