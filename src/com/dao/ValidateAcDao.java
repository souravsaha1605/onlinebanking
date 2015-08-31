package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.factory.DbFactory;

public class ValidateAcDao {

	PreparedStatement ps;
	int result;
	public int validateAcNo(String acNo)
	{
		try
		{
			
			
		ps=DbFactory.getMysqlConnection().prepareStatement("SELECT COUNT(*) FROM l_of_acnts where ac_no=(?)");
		
		ps.setString(1,acNo);
		
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			result=rs.getInt(1);
		}
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
	public int validateUId(String uId,String password,String acNo)
	{
		
		try
		{
			
			
		ps=DbFactory.getMysqlConnection().prepareStatement("SELECT COUNT(*) FROM cstmr_details where cstmr_id=?&&password=?&&ac_no=?");
		
		ps.setString(1,uId);
		ps.setString(2, password);
		ps.setString(3, acNo);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			result=rs.getInt(1);
		}
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}
}
