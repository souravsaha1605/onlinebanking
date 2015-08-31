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

import com.dao.CustomerDao;
import com.dao.DepoWdraw;
import com.dao.TransacDao;
import com.model.Customer;
import com.model.Transaction;

/**
 * Servlet implementation class SecureTransfer
 */
@WebServlet("/SecureTransfer")
public class SecureTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecureTransfer() {
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
			
		
		String uId = request.getParameter("uId");
		String password = request.getParameter("pwd");
		
		Transaction transac=(Transaction)request.getAttribute("trnsfrKey");
		String frmAcNo=transac.getFrmAcNo();
		
		
		PrintWriter out = response.getWriter();
		out.println(frmAcNo);
		out.println("inside securetransfer");
		out.println(uId);
		}else{
			response.sendRedirect("/CustomerLogin.jsp");
		}
		}
	}

		
		
	


