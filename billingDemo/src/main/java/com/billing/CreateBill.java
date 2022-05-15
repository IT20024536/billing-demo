package com.billing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateBill
 */
@WebServlet("/CreateBill")
public class CreateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String units = request.getParameter("units");
			String bill = request.getParameter("bill");
			
			MySQLDBConnection con = new MySQLDBConnection();
			
			con.billInsert(name, phone, Float.parseFloat(units), Float.parseFloat(bill));
			
			response.sendRedirect(request.getContextPath() + "/Bills.jsp");
		}
		catch (Exception ex) {
			response.sendRedirect(request.getContextPath() + "/billinsert.jsp");
		}
	}

}
