package com.transactioncontroller;

import java.io.IOException;
import java.io.PrintWriter;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepoWdraw;
import com.dao.TransacDao;
import com.model.DepositWithdraw;
import com.model.Transaction;

/**
 * Servlet implementation class DepostWthdraw
 */
@WebServlet("/DepostWthdraw")
public class DepostWthdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int result;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepostWthdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String acNo=request.getParameter("acNo");
		float amount=Float.parseFloat(request.getParameter("amount"));
		String mode=request.getParameter("mode");
		
		//for temporary purpose the below commented code has been rejected
		/*
		DepositWithdraw dw = new DepositWithdraw();    //creating an object for the DepositWithdraw Bean Class 
		dw.setAcNo(acNo);
		dw.setAmount(amount);
		dw.setMode(mode);
		request.setAttribute("dwKey", dw);
		DepoWdraw dwObj=new DepoWdraw();
		
		*/
		Transaction trnsObj= new Transaction();
		trnsObj.setFrmAcNo(acNo);
		trnsObj.settAcNo("bank");
		trnsObj.setBalance(amount);
		trnsObj.setMode(mode);
		request.setAttribute("dwKey", trnsObj);
		DepoWdraw dw=new DepoWdraw();
		
		TransacDao td=new TransacDao();
		
		PrintWriter out = response.getWriter();
		if(mode.equals("withdraw"))
		{
		
			result=dw.chkWithdraw(acNo, amount);
			if(result>0)
			{
				out.println("withdraw can be proceeded");
				
			}else
			{
				RequestDispatcher rd= request.getRequestDispatcher("/DepostWthdraw.jsp");
				rd.forward(request, response);
			}
			
			
			result=dw.balanceWithdraw(acNo, amount);
			if(result>0)
			{
				out.println("withdraw successful");
				//including it to transaction
				int result1=td.insertTransac(acNo, "bank", "withdraw",  amount); 
				
				RequestDispatcher rd= request.getRequestDispatcher("/DepoWdrawSucc.jsp");
				rd.forward(request, response);
			}
			
		}else{												//getting an error in elseif
			
			int result=dw.balanceDeposit(acNo, amount);
			if(result>0)
			{
				out.println("deposit successful");
				
				//including it to transaction
				int result1=td.insertTransac(acNo, "bank", "deposit",  amount);
				
				RequestDispatcher rd= request.getRequestDispatcher("/DepoWdrawSucc.jsp");
				rd.forward(request, response);
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
