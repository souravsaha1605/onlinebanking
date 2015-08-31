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
 * Servlet implementation class DeleteControl
 */
@WebServlet("/DeleteControl")
public class DeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acNo=request.getParameter("acNo");
		String mobNo=request.getParameter("mobNo");
		String uId=request.getParameter("uId");
		String update=request.getParameter("update");
		
		PrintWriter out = response.getWriter();
		
		CustomerDao cstmr=new CustomerDao();
		Customer cstmrSet=new Customer();
		cstmrSet.setAcNo(acNo);
		cstmrSet.setMobNo(mobNo);
		cstmrSet.setUpdate(update);
		request.setAttribute("updateKey", cstmrSet);
		int result=cstmr.validateUpdate(acNo, uId, mobNo);
		if(result>0)
		{
			out.println("valid input");
			int result1=cstmr.deleteAccount(acNo, uId);
			if(result1>0)
			{
			request.setAttribute("msg", "your account has been removed");
			RequestDispatcher rDispatcher=request.getRequestDispatcher("DeleteCstmr.jsp");
			rDispatcher.forward(request, response);
			}else{
				request.setAttribute("msg", "Sorry,the account can not be deleted ");
				RequestDispatcher rDispatcher=request.getRequestDispatcher("DeleteCstmr.jsp");
				rDispatcher.forward(request, response);
			}
		}else{
			request.setAttribute("msg", "Sorry,the details you have entered is invalid");
			RequestDispatcher rDispatcher=request.getRequestDispatcher("DeleteCstmr.jsp");
			rDispatcher.forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
