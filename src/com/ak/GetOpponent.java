package com.ak;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetOpponent extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse  res) throws IOException, ServletException {
		
		String action=req.getParameter("submit");
		HttpSession session=req.getSession();
		String method=(String) session.getAttribute("Message");
		String str="";
		if(action.equalsIgnoreCase("value")) {
		
			String name=req.getParameter("oname");
			if(method.equalsIgnoreCase("strike")) {
				str=Keys.villainAction(1,name,0,"");
			}
			else if(method.equalsIgnoreCase("compliment")) {
				
				String compliment=(String) session.getAttribute("compliment");
				str=Keys.villainAction(8, name, 0,compliment);
				str+="<br/>"+Keys.boostEnergy(1);
			}else if(method.equalsIgnoreCase("show Compliment")) {
				str=Keys.villainAction(10, name, 0,"");
			}
		
			
			session.setAttribute("Message", str);
			
			RequestDispatcher r= req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
			
			
		}
		if(action.equalsIgnoreCase("key")) {
			
			int key=Integer.parseInt(req.getParameter("key"));
			System.out.println(key+"key");
			if(method.equalsIgnoreCase("strike"))
				str=Keys.villainAction(1,"",key,"");
			else if(method.equalsIgnoreCase("compliment")) {
				
				String compliment=(String) session.getAttribute("compliment");
				str=Keys.villainAction(8,"", key,compliment);
				str+="<br/>"+Keys.boostEnergy(1);
			}
			else if(method.equalsIgnoreCase("show Compliment")) {
				System.out.println("a1");
				str=Keys.villainAction(10,"", key,"");
				System.out.println("a2");
			}
		
		
			
			session.setAttribute("Message", str);
			
			RequestDispatcher r= req.getRequestDispatcher("/Actions.jsp");
			r.forward(req, res);
			
			
		}
		}
	}
