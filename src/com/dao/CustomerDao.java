package com.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.DbFactory;
import com.model.Customer;

public class CustomerDao {

	PreparedStatement pStatement;
	int result;
	String result2;

	public int insertCstmr(String empName,String uId,String password,String mobNo)
	{
		try
		{
			
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("insert into cstmr_details(u_name,password,cstmr_id,ph_no) values(?,?,?,?)");
		
		pStatement.setString(1, empName);
		pStatement.setString(2, password);
		pStatement.setString(3, uId);
		//pStatement.setString(4, acNo);
		pStatement.setString(4, mobNo);
		
		
		result=pStatement.executeUpdate(); 
		

		pStatement=DbFactory.getMysqlConnection().prepareStatement("select ac_no from cstmr_details order by ac_no desc limit 1");
		int acNo=pStatement.executeUpdate();
		final int maxLength=6;
		
		String acNum=Integer.toString(acNo);
		for(int i=acNum.length();i<maxLength;i++)
		{
			acNum="0"+acNum;
		}
		int acNumber=Integer.parseInt(acNum);
		System.out.println(acNumber);

		pStatement=DbFactory.getMysqlConnection().prepareStatement("update cstmr_details set acNo=? where ac_no=?");
		pStatement.setInt(1, acNumber);
		pStatement.setInt(2, acNo);
		pStatement.executeUpdate();
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
	
	public int insertAccount(String acNo)
	{
		try
		{
			
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("insert into l_of_acnts (ac_no) values(?)");
		
		
		pStatement.setString(1, acNo);
		
		result=pStatement.executeUpdate();   
		
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
	
	
	public List<Customer> checkLogin(String uId,String password)
	{
		List<Customer> list = new ArrayList<Customer>();
		
			
		try
		{
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("select * from cstmr_details where cstmr_id=? and password=? ");
		pStatement.setString(1, uId);
		pStatement.setString(2, password);
		ResultSet rs = pStatement.executeQuery();
		Customer cstmr ;
		while(rs.next())
		{
			cstmr=new Customer();
			
			cstmr.setName(rs.getString(1));
			cstmr.setPassword(rs.getString(2));
			cstmr.setUserId(rs.getString(3));
			list.add(cstmr);
		}
		}catch(SQLException e){System.out.println(e);}
		catch(NumberFormatException e){}
		return list;
	}

	public List<Customer> viewAccounts(String uId,String password)
	{
		List<Customer> list = new ArrayList<Customer>();
		
			
		try
		{
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("select * from cstmr_details where cstmr_id=? ");
		pStatement.setString(1, uId);
		//pStatement.setString(2, password);
		ResultSet rs = pStatement.executeQuery();
		Customer cstmr ;
		while(rs.next())
		{
			cstmr=new Customer();
			
			cstmr.setName(rs.getString(1));
			cstmr.setPassword(rs.getString(2));
			cstmr.setUserId(rs.getString(3));
			list.add(cstmr);
		}
		}catch(SQLException e){System.out.println(e);}
		catch(NumberFormatException e){}
		return list;
	}
	
	public int validateUpdate(String acNo,String uId,String mobNo)
	{
		try
		{
			
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("SELECT COUNT(*) FROM cstmr_details where ac_no=(?)&&cstmr_id=(?)&&ph_no=(?)");
		
		pStatement.setString(1,acNo);
		pStatement.setString(2,uId);
		pStatement.setString(3,mobNo);
		
		ResultSet rs = pStatement.executeQuery();
		if(rs.next())
		{
			result=rs.getInt(1);
		}
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
	
	public int deleteAccount(String acNo,String uId)
	{
		try
		{
			
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("delete from cstmr_details where cstmr_id=?&&ac_no=?");
		
		
		pStatement.setString(1, uId);
		pStatement.setString(2, acNo);
		
		result=pStatement.executeUpdate();   
		
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}	
	public String returnAcNo()
	{
		try
		{
			
			
		pStatement=DbFactory.getMysqlConnection().prepareStatement("select ac_no from cstmr_details order by ac_no desc limit 1");
		
		
		
		ResultSet rs=pStatement.executeQuery();
		if(rs.next())
		{
			result2=rs.getString(1);
		}
		
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result2;
	}
	
	public int updateCstmr(String acNo,String upName,String upAddress,String upPhNo )
	{
		System.out.println(upAddress);
		System.out.println(upPhNo);
		try
		{
			/*if(upName!=null)
			{
				pStatement=DbFactory.getMysqlConnection().prepareStatement("update cstmr_details set u_name=? where ac_no=?");
				pStatement.setString(1, upName);
				pStatement.setString(2, acNo);
				
				result=pStatement.executeUpdate(); 
			}else */if(upAddress!=null)
			{
				pStatement=DbFactory.getMysqlConnection().prepareStatement("update cstmr_details set address=? where ac_no=?");
				pStatement.setString(1, upAddress);
				pStatement.setString(2, acNo);
				
				result=pStatement.executeUpdate(); 
			}else /*if(upPhNo!=null)*/
			{
				pStatement=DbFactory.getMysqlConnection().prepareStatement("update cstmr_details set ph_no=? where ac_no=?");
				pStatement.setString(1, upName);
				pStatement.setString(2, acNo);				//getting updated if chosen but with null value if it is not the first statement of if else
				
				result=pStatement.executeUpdate(); 
			}
			
		
		
		
		result=pStatement.executeUpdate(); 
		
		
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}

}