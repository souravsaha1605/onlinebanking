package com.controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.Customer;

/**
 * Servlet implementation class InsertDetails
 */
@WebServlet("/InsertDetails")
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDetails() {
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
		
		PrintWriter out =response.getWriter();
		Customer cstmrObj=(Customer)request.getAttribute("cstmrKey");
		String name = cstmrObj.getName();
		String userId = cstmrObj.getUserId();
		String password = cstmrObj.getPassword();
		String mobNo=cstmrObj.getMobNo();
		String acNo=cstmrObj.getAcNo();
		
		CustomerDao cstmrInsObj=new CustomerDao();
		int result=cstmrInsObj.insertCstmr(name,userId,password,mobNo);
		if(result>0)
		{
			String result2=cstmrInsObj.returnAcNo();
			if(result2!=null)
			{
				
			
			result=cstmrInsObj.insertAccount(result2);
			if(result>0)
			{
				//out.println("account number inserted");
			}
			
			//out.println("customer details entered");
			cstmrObj.setAcNo(result2);
			cstmrObj.setPassword(password);
			request.setAttribute("UIdPassKey", cstmrObj);
			RequestDispatcher rDispatcher= request.getRequestDispatcher("CheckDetails.jsp");
			rDispatcher.forward(request, response);
			//out.println(result2);
			//out.println(password);
			
			}
		}
		
		
		
	}

}
