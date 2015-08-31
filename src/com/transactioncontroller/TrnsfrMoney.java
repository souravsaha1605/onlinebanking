package com.transactioncontroller;

import java.io.IOException;
import java.io.PrintWriter;







import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DepoWdraw;
import com.dao.TransacDao;
import com.dao.ValidateAcDao;
import com.model.Customer;
import com.model.Transaction;

/**
 * Servlet implementation class TrnsfrMoney
 */
@WebServlet("/TrnsfrMoney")
public class TrnsfrMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int wDrawSucc,wDeposit; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrnsfrMoney() {
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
			
		Customer cstmr=(Customer)session.getAttribute("user");
		String userId=cstmr.getUserId();
		
		
		String frAcNo=request.getParameter("fromAcNo");
	    String tAcNo=request.getParameter("toAcNo");
	   float balance=Float.parseFloat(request.getParameter("amount"));
	   
	   String uId=request.getParameter("uId");
	   if(userId.equals(uId))
	   {
	   String password=request.getParameter("pwd");
	   PrintWriter out=response.getWriter();
	   out.println("inside trnsfer money");
	   out.println(balance);
	    Transaction transac = new Transaction();
	    transac.setFrmAcNo(frAcNo);
	    transac.settAcNo(tAcNo);
	    transac.setMode("withdraw");
	    transac.setBalance(balance);
	    
	    request.setAttribute("trnsfrKey", transac);
	  
	    //RequestDispatcher rd= request.getRequestDispatcher("/Trial.jsp");
		//rd.forward(request, response);
	    
	    DepoWdraw dw= new DepoWdraw();
	   TransacDao td=new TransacDao();
	 /*
	  * 
	  *   check whether the transfer can be done or not ,by checking the balance
	  *   if possible check whether both the account number is correct or not
	  */
	   int vaAcRes,vaAcId;
	   
	   
	   wDrawSucc=dw.chkWithdraw(frAcNo, balance);
		if( wDrawSucc>0)
		{
			out.println("withdraw can be proceeded");
			ValidateAcDao vac=new ValidateAcDao();
			
			vaAcRes=vac.validateAcNo(tAcNo);
			if(vaAcRes>0)
			{
				vaAcId=vac.validateUId(uId, password, frAcNo);
			
			if(vaAcId>0)
			{
				out.println("userId password matched with the particular account number");
				wDrawSucc=dw.balanceWithdraw(frAcNo, balance);
				if( wDrawSucc>0)
				{
					wDeposit=dw.balanceDeposit(tAcNo, balance);
					
					if(wDeposit>0)
					{
						out.println("transaction successful");
						int result1=td.insertTransac(frAcNo, tAcNo, "withdraw",  balance); // if in the dao of corresponding to these calling method the order of insertion in the table is not in order then it will show method not created
						int result2=td.insertTransac(tAcNo, frAcNo, "deposit", balance);
						//check if account number is not correctly typed
					}
					//RequestDispatcher rd= request.getRequestDispatcher("TransacControl");
					//rd.forward(request, response);
				}
				
			}else
			{
				out.println("userId password do not match with the particular account");
			}
				
				//RequestDispatcher rd = request.getRequestDispatcher("/SecureTransferChk.html");
			//rd.forward(request, response);
			
			
			}else
			{
				RequestDispatcher rd = request.getRequestDispatcher("InvalidAcNo.jsp");
				rd.forward(request, response);
			}
		}
		}else
		{
			request.setAttribute("idErrorMsg", "This account doesnot belong to you");
			RequestDispatcher rd=request.getRequestDispatcher("Transfer.jsp");
			rd.forward(request, response);
		}
		}else{
			response.sendRedirect("Logout.jsp");
		}
		
		
		 	
	
	  
	
	}

}
