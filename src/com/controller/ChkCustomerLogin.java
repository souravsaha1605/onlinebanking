package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.Customer;



/**
 * Servlet implementation class ChkCustomerLogin
 */
@WebServlet("/ChkCustomerLogin")
public class ChkCustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkCustomerLogin() {
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
		
		PrintWriter out= response.getWriter();
		String userId=request.getParameter("uId");
		String password=request.getParameter("pwd");
		Customer cstmr=new Customer();
		cstmr.setUserId(userId);
		cstmr.setPassword(password);
		request.setAttribute("UIdPassKey", cstmr);
		//the below printing statement is for temporary
		out.println(userId);
		CustomerDao cstmrObj = new CustomerDao();
		List<Customer> list = cstmrObj.checkLogin(userId, password);
		
		//the below printing statement is only for temporary purpose, its only to show in the eclipse.not in the browser
		/*
		for(Customer cstmr :list)
		{
			System.out.println(cstmr.getName());
			System.out.println(cstmr.getPassword());
			System.out.println(cstmr.getUserId());
		}
		*/
		if(list.isEmpty())
		{
			request.setAttribute("msg", "Sorry invalid User Id or Password ");
			RequestDispatcher rd= request.getRequestDispatcher("/CustomerLogin.jsp");
			rd.forward(request, response);
		}else{
			// the printing is for temporary purpose it is supposed to redirect to the home page
			
			out.println("successful login");
			//out.println("display the accounts present for that particular userid");
			HttpSession session=request.getSession();
			session.setAttribute("user", cstmr);
		
			List<Customer> listDisplay =(List<Customer>)cstmrObj.viewAccounts(userId, password);
			out.print(listDisplay.isEmpty());
			request.setAttribute("viewKey", listDisplay);
			
			/*for(Customer cstmrDisp : listDisplay)
			{
				cstmrDisp=new Customer();
				out.println(cstmrDisp.getName());
				out.println(cstmrDisp.getPassword());
			}*/
			
			//RequestDispatcher rd=request.getRequestDispatcher("ViewAccounts");
			//RequestDispatcher rd=request.getRequestDispatcher("CheckDetails.jsp");
			RequestDispatcher rd= request.getRequestDispatcher("/CustomerHome.jsp");
			rd.forward(request, response);
			//have to send the userId to a servlet from where it will send it to the dao method to select the list of accounts for that particular id
			//whatever is there in the table p3
		}
	}

}
