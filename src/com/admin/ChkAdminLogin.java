package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChkAdminLogin
 */
@WebServlet("/ChkAdminLogin")
public class ChkAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		//out.println("hello");
		
		String uId = request.getParameter("uId");
		String password = request.getParameter("pwd");
		
		if(uId.equals("user")&& password.equals("user123"))
		{
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/AdminRegis.html");
			rDispatcher.forward(request, response);
		}else
		{
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/AdminLoginFailure.jsp");
			rDispatcher.forward(request, response);
		}
	}

}
