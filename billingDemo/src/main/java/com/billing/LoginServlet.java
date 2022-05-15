package com.billing;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		MySQLDBConnection cn = new MySQLDBConnection();
		boolean res = cn.validateUser(username, password);
//		try {
//				List<Billing> billDetails = BillingDBUtil.validate(username, password);
//				request.setAttribute("billDetails", billDetails);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
		if(res) {
//			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
//			dis.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/billinsert.jsp");
		}
		else {
//			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//			dis.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

}
