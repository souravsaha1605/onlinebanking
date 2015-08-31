package com.transactioncontroller;

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

import com.dao.TransacDao;
import com.model.Customer;
import com.model.Transaction;

/**
 * Servlet implementation class ViewAccounts
 */
@WebServlet("/ViewAccounts")
public class ViewAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccounts() {
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
		HttpSession session=request.getSession(false);
		if(session.getAttribute("user")!=null )
		{
			Customer object=(Customer)request.getAttribute("UIdPassKey");
			//String uId=object.getUserId();
			String uId=(String)session.getAttribute("user");
		TransacDao td=new TransacDao();
		PrintWriter out=response.getWriter();
		
		List<Transaction> list =td.viewAccount(uId);
		if(list.isEmpty())
		{
			out.println("inside list empty");
		}
		for(Transaction ts:list)
		{
			out.println(uId);
			out.println(ts.getFrmAcNo());
			out.println(ts.getBalance());
			out.println("		");
			
		}
		request.setAttribute("viewKey", list);
		
		
		out.println(uId);
		
		//RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.jsp");
		//rd.forward(request, response);
	}
		else{
			
		response.sendRedirect("Logout.jsp");
		
		}
		}

}
