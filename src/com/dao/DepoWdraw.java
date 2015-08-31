package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.factory.DbFactory;


public class DepoWdraw {
	PreparedStatement ps;
	int result;
	float avlBalance;
	TransacDao transac=new TransacDao(); 
	
	public int chkWithdraw(String acNo,float amount)
	{
		
		try
		{
			
			
		ps=DbFactory.getMysqlConnection().prepareStatement("SELECT COUNT(*) FROM l_of_acnts where ac_no=(?)&&balance >(?)");
		
		ps.setString(1,acNo);
		ps.setFloat(2, amount);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			result=rs.getInt(1);
		}
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
	
	public int balanceDeposit(String acNo,float amount)
	{
		
		try
		{
			
		ps=DbFactory.getMysqlConnection().prepareStatement("select * from l_of_acnts where ac_no=? ");
		ps.setString(1, acNo);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			
			
			 avlBalance=rs.getFloat(3);     	//the number should be based on the column number in which it is present
			
		}
		avlBalance=avlBalance+amount;
		transac.getAvlBalance(avlBalance);
		
		ps=DbFactory.getMysqlConnection().prepareStatement("update l_of_acnts set balance=? where ac_no=? ");
		ps.setFloat(1, avlBalance);
		ps.setString(2, acNo);
		
		result=ps.executeUpdate();
		
		
		}catch(SQLException e){}
		catch(NumberFormatException e){}
		return result;
	}
	
	public int balanceWithdraw(String acNo,float amount)
	{
		
		try
		{
			
		ps=DbFactory.getMysqlConnection().prepareStatement("select * from l_of_acnts where ac_no=? ");
		ps.setString(1, acNo);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			
			
			 avlBalance=rs.getFloat(3);     	//the number should be based on the column number in which it is present
			
		}
		avlBalance=avlBalance-amount;
	
		transac.getAvlBalance(avlBalance);
		ps=DbFactory.getMysqlConnection().prepareStatement("update l_of_acnts set balance=? where ac_no=? ");
		ps.setFloat(1, avlBalance);
		ps.setString(2, acNo);
		
		result=ps.executeUpdate();
		}catch(SQLException e){}
		catch(NumberFormatException e){}
		return result;
	}
	

	

}
