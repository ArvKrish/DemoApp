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

public class Move extends HttpServlet {
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

				System.out.println(session.getId());

				int uKey = (int) session.getAttribute("uKey");

				String name = req.getParameter("Action");

				if ("strike".equalsIgnoreCase(name)) {

					if (Keys.villainSize(uKey) < 2) {
						String message = Keys.villainAction(uKey, 1, "", 0, "");

						double playerHealth = Keys.findPlayer(uKey).getHealth();
						session.setAttribute("playerHealth", playerHealth);

						session.setAttribute("Message", message);
						RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
						r.forward(req, res);
					} else {
						String message = "strike";
						session.setAttribute("Message", message);

						RequestDispatcher r = req.getRequestDispatcher("/Opponent.jsp");
						r.forward(req, res);
					}

				}

				else if ("strikeAll".equalsIgnoreCase(name)) {

					String message = Keys.villainActionAll(uKey, 1);
					session.setAttribute("Message", message);

					double playerHealth = Keys.findPlayer(uKey).getHealth();
					session.setAttribute("playerHealth", playerHealth);

					RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
					r.forward(req, res);

				}

				else if ("addVillain".equalsIgnoreCase(name)) {
					String message = "";
					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/NewOpponent.jsp");
					r.forward(req, res);
				} else if ("boost".equalsIgnoreCase(name)) {
					String message = Keys.boostEnergy(uKey, 0);

					double playerHealth = Keys.findPlayer(uKey).getHealth();
					session.setAttribute("playerHealth", playerHealth);

					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
					r.forward(req, res);
				} else if ("showvillain".equalsIgnoreCase(name)) {
					String message = Keys.showList(uKey);
					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
					r.forward(req, res);
				} else if ("compliment".equalsIgnoreCase(name)) {
					String message = "Compliment";
					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/Compliment.jsp");
					r.forward(req, res);
				} else if ("showcompliment".equalsIgnoreCase(name)) {
					String message = "Show Compliment";
					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/Opponent.jsp");
					r.forward(req, res);
				} else if ("summary".equalsIgnoreCase(name)) {
					String message = Keys.allSummary(uKey);
					session.setAttribute("Message", message);
					RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
					r.forward(req, res);
				} else if ("exit".equalsIgnoreCase(name)) {
					String message = "";
					session.setAttribute("Message", message);
					session.invalidate();
					System.out.println(session.getId());
					res.sendRedirect("/DemoApp/");
					return;
				}
			}

			else {
				RequestDispatcher r = req.getRequestDispatcher("/Actions.jsp");
				r.forward(req, res);
			}
		}
	}
}