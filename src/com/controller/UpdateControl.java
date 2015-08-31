package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dao.CustomerDao;
import com.model.Customer;

/**
 * Servlet implementation class UpdateControl
 */
@WebServlet("/UpdateControl")
public class UpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControl() {
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
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateSet.jsp");
			rd.forward(request, response);
			
		}else{
			request.setAttribute("msg", "Sorry,the details you have entered is invalid");
			RequestDispatcher rd=request.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
