package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;

/**
 * Servlet implementation class AdminRegis
 */
@WebServlet("/AdminRegis")
public class AdminRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegis() {
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
		
		String name = request.getParameter("uName");
		String userId = request.getParameter("uId");
		//String password = request.getParameter("pwd");
		String acNo=request.getParameter("acNo");
		String address = request.getParameter("address");
		String mobNo = request.getParameter("mobNo");
		String gender = request.getParameter("gender");
		String branch = request.getParameter("branch");
		String emailId = request.getParameter("emailId");
		//you can generate a password
		StringUtils pGenerate=new StringUtils();
	String password=pGenerate.generateRandomPassword();   //if the jsp page works fine then the comment will be removed and previous input should not be taken from the user
		
		Customer cstmrObj = new Customer();
		cstmrObj.setName(name);
		cstmrObj.setUserId(userId);
		cstmrObj.setPassword(password);
		cstmrObj.setAcNo(acNo);
		cstmrObj.setMobNo(mobNo);
		//cstmrObj.setBranch(branch);
		
		request.setAttribute("cstmrKey", cstmrObj);
	//RequestDispatcher rd = request.getRequestDispatcher("/AdminRegis.jsp");   //using this it reviews the data from the user and if the user creates create then only the data is inserted
		RequestDispatcher rd = request.getRequestDispatcher("InsertDetails");	//using this its directly inserting the data without reviewing from the user
		rd.forward(request, response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
