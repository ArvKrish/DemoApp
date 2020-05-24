package com.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ak.Keys;

public class Welcome extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		Enumeration<String> en = req.getParameterNames();

		if (en.hasMoreElements()) {

			String name = (req.getParameter("pname"));
			int power = Integer.parseInt(req.getParameter("power"));
			int uKey = Keys.start(name, power);
			if (uKey > 0) {

				HttpSession session = req.getSession(true);

				System.out.println(session.getId());

				String playerName = Keys.findPlayer(uKey).getName();
				double playerHealth = Keys.findPlayer(uKey).getHealth();
				double playerPower = Keys.findPlayer(uKey).getPower();
				session.setAttribute("playerName", playerName);
				session.setAttribute("playerHealth", playerHealth);
				session.setAttribute("playerPower", playerPower);
				session.setAttribute("uKey", uKey);
				RequestDispatcher r = req.getRequestDispatcher("/NewOpponent.jsp");
				r.forward(req, res);
			}

		}
		else {
			res.sendRedirect("/DemoApp/");
		}
	}

}
