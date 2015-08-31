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
import com.model.DepositWithdraw;
import com.model.Transaction;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/TransacControl")
public class TransacControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransacControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession(false);
		if(session.getAttribute("user")!=null )
		{
			
		
		String prmAcNo;
prmAcNo=request.getParameter("fromAcNo");
Transaction transac = new Transaction();
transac.setFrmAcNo(prmAcNo);
request.setAttribute("viewKey", transac);

	TransacDao transacDao=new TransacDao();
	PrintWriter out = response.getWriter();
List<Transaction> list =transacDao.selectTransac(prmAcNo);

request.setAttribute("transacKey", list);
RequestDispatcher dispatcher=request.getRequestDispatcher("ViewHistory.jsp");
dispatcher.forward(request, response);
		}
		
		else{
			response.sendRedirect("Logout.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
