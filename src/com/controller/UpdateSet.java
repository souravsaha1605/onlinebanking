package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;

/**
 * Servlet implementation class UpdateSet
 */
@WebServlet("/UpdateSet")
public class UpdateSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String acNo=request.getParameter("acNo");
		String upName=request.getParameter("uName");
		String upAddress=request.getParameter("address");
		String upPhNo=request.getParameter("PhNo");
		out.println(upPhNo);
		CustomerDao cstmr=new CustomerDao();
		
		int result=cstmr.updateCstmr(acNo, upName, upAddress, upPhNo);
		if(result>0)
		{
			out.println("Your account has been updated");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
