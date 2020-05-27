package com.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Keys;

public class Move extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> en = request.getParameterNames();

		ServletContext context = getServletContext();

		HttpSession session = request.getSession(false);
		if (en.hasMoreElements()) {
			
			context.log(session.getId());

			int uKey = (int) session.getAttribute("uKey");

			String name = request.getParameter("Action");

			if ("strike".equalsIgnoreCase(name)) {

				if (Keys.villainSize(uKey) < 2) {
					String message = Keys.villainAction(uKey, 1, "", 0, "");

					double playerHealth = Keys.findPlayer(uKey).getHealth();
					session.setAttribute("playerHealth", playerHealth);
					session.setAttribute("Message", message);
					RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
					r.forward(request, response);
				} else {
					String message = "strike";
					session.setAttribute("Message", message);

					RequestDispatcher r = request.getRequestDispatcher("/Opponent.jsp");
					r.forward(request, response);
				}

			}

			else if ("strikeAll".equalsIgnoreCase(name)) {

				String message = Keys.villainActionAll(uKey, 1);
				session.setAttribute("Message", message);

				double playerHealth = Keys.findPlayer(uKey).getHealth();
				session.setAttribute("playerHealth", playerHealth);
				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);

			}

			else if ("addVillain".equalsIgnoreCase(name)) {
				String message = "";
				session.setAttribute("Message", message);
				RequestDispatcher r = request.getRequestDispatcher("/NewOpponent.jsp");
				r.forward(request, response);
			} else if ("boost".equalsIgnoreCase(name)) {
				String message = Keys.boostEnergy(uKey, 0);

				double playerHealth = Keys.findPlayer(uKey).getHealth();
				session.setAttribute("playerHealth", playerHealth);
				context.log(uKey + " - " + message);
				session.setAttribute("Message", message);
				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);
			} else if ("showvillain".equalsIgnoreCase(name)) {
				String message = Keys.showList(uKey);
				session.setAttribute("Message", message);
				context.log(uKey + " - " + message);
				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);
			} else if ("compliment".equalsIgnoreCase(name)) {
				String message = "Compliment";
				session.setAttribute("Message", message);
				context.log(uKey + " - " + message);
				RequestDispatcher r = request.getRequestDispatcher("/Compliment.jsp");
				r.forward(request, response);
			} else if ("showcompliment".equalsIgnoreCase(name)) {
				String message = "Show Compliment";
				session.setAttribute("Message", message);
				context.log(uKey + " - " + message);
				RequestDispatcher r = request.getRequestDispatcher("/Opponent.jsp");
				r.forward(request, response);
			} else if ("summary".equalsIgnoreCase(name)) {
				String message = Keys.allSummary(uKey);
				session.setAttribute("Message", message);
				context.log(uKey + " - " + message);
				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);
			} else if ("exit".equalsIgnoreCase(name)) {
				String message = "";
				session.setAttribute("Message", message);
				session.invalidate();

				context.log(uKey + " - " + message);
				response.sendRedirect("/DemoApp/");
				return;
			}

		}

		else {
			context.log("No parameters- Redirect");
			RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
			r.forward(request, response);
		}
	}
}
