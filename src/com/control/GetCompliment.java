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

public class GetCompliment extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> en = request.getParameterNames();
		HttpSession session = request.getSession(false);
		ServletContext context= getServletContext();
		if (en.hasMoreElements()) {

			String compliment = request.getParameter("compliment");
			if (compliment == null)
				response.sendRedirect("/DemoApp/");

			session.setAttribute("compliment", compliment);
			session.setAttribute("Message", "Compliment");

			RequestDispatcher r = request.getRequestDispatcher("/Opponent.jsp");
			r.forward(request, response);

		} else {
			context.log("No parameters- Redirect");
			response.sendRedirect("/DemoApp/Actions");

		}
	}
}
