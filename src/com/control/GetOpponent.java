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

public class GetOpponent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> en = request.getParameterNames();
		HttpSession session = request.getSession(false);
		ServletContext context= getServletContext();
		context.log(session.getId());
		if (en.hasMoreElements()) {

			String action = request.getParameter("submit");

			int uKey = (int) session.getAttribute("uKey");
			String method = (String) session.getAttribute("Message");
			//System.out.println(method);

			String str = "";
			if ("value".equalsIgnoreCase(action)) {

				String name = request.getParameter("oname");
				if ("strike".equalsIgnoreCase(method)) {
					str = Keys.villainAction(uKey, 1, name, 0, "");
				} else if ("compliment".equalsIgnoreCase(method)) {

					String compliment = (String) session.getAttribute("compliment");
					str = Keys.villainAction(uKey, 8, name, 0, compliment);
					str += "<br/>" + Keys.boostEnergy(uKey, 1);
				} else if ("show Compliment".equalsIgnoreCase(method)) {
					str = Keys.villainAction(uKey, 10, name, 0, "");
				}
				double playerHealth = Keys.findPlayer(uKey).getHealth();
				session.setAttribute("playerHealth", playerHealth);

				session.setAttribute("Message", str);

				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);

			}
			if ("key".equalsIgnoreCase(action)) {

				int key = Integer.parseInt(request.getParameter("key"));
				context.log(key + "key");
				if ("strike".equalsIgnoreCase(method))
					str = Keys.villainAction(uKey, 1, "", key, "");
				else if ("compliment".equalsIgnoreCase(method)) {

					String compliment = (String) session.getAttribute("compliment");
					str = Keys.villainAction(uKey, 8, "", key, compliment);
					str += "<br/>" + Keys.boostEnergy(uKey, 1);
				} else if ("show Compliment".equalsIgnoreCase(method)) {
					str = Keys.villainAction(uKey, 10, "", key, "");
				
				}

				double playerHealth = Keys.findPlayer(uKey).getHealth();
				session.setAttribute("playerHealth", playerHealth);

				session.setAttribute("Message", str);
				context.log(uKey+" - " + str);
				context.log(uKey+" - " + playerHealth);
				
				RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
				r.forward(request, response);

			}
		} else {
			context.log("No parameter - redirect ");
			RequestDispatcher r = request.getRequestDispatcher("/Actions.jsp");
			r.forward(request, response);

		}
	}
}
