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

public class Opponent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> en = request.getParameterNames();
		ServletContext context = getServletContext();

		HttpSession session = request.getSession(false);

		context.log(session.getId());
		if (en.hasMoreElements()) {

			int uKey = (int) (session.getAttribute("uKey"));
			String name = (request.getParameter("oname"));
			int key = Integer.parseInt(request.getParameter("key"));
			boolean check = Keys.newVillain(uKey, name, key);

			if (check) {
				session.setAttribute("Message", "New Villain added");
				context.log(uKey + " - " + "New Villain added");
			} else {
				session.setAttribute("Message", "Duplicate code. Try again!");
				context.log(uKey + " - " + "Duplicate code. Try again!");
			}
			session.setAttribute("villainSize", Keys.villainSize(uKey));

			RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
			r.forward(request, response);

		} else {
			context.log("No parameters- Redirect");
			RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
			r.forward(request, response);
		}
	}

}
