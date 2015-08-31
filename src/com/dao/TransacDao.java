package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.DbFactory;

import com.model.Transaction;


public class TransacDao {
	PreparedStatement ps;
	int result;
	float avlBalance;

	public int insertTransac(String prAcNo,String secAcNo,String mode,float amount)
	{
		try
		{
			
			
		//ps=DbFactory.getMysqlConnection().prepareStatement("insert into t11 (prm_ac_no,sec_ac_no,balance,mode,avlBalance) values(?,?,?,?,?)");
		ps=DbFactory.getMysqlConnection().prepareStatement("insert into t10 (prm_ac_no,sec_ac_no,balance,mode) values(?,?,?,?)");
		ps.setString(1, prAcNo);
		ps.setString(2, secAcNo);
		
		ps.setFloat(3, amount);
		ps.setString(4, mode);
		//ps.setFloat(5,this.avlBalance);
	
		result=ps.executeUpdate();   
		
		}catch(SQLException e){System.out.println("SQl"+e);}
		catch(NumberFormatException e){System.out.println("nm"+e);}
		return result;
	}

	public List<Transaction> selectTransac(String prmAcNo)
	{
		List<Transaction> list = new ArrayList<Transaction>();
			
		try
		{
			
		ps=DbFactory.getMysqlConnection().prepareStatement("select * from t10 where prm_ac_no=?");
		ps.setString(1, prmAcNo);
		
		ResultSet rs = ps.executeQuery();
		Transaction transac ;
		while(rs.next())
		{
			transac=new Transaction();
			
			transac.setFrmAcNo(rs.getString(1));
			transac.settAcNo(rs.getString(2));
			transac.setBalance(rs.getFloat(3));
			transac.setMode(rs.getString(4));
			transac.setDate(rs.getDate(5));
			//transac.setAvlBalance(avlBalance);
			
			list.add(transac);
		}
		}catch(SQLException e){System.out.println(e);}
		catch(NumberFormatException e){}
		return list;
	}
	
	
	public List<Transaction> viewAccount(String cstmrId)
	{
		List<Transaction> list = new ArrayList<Transaction>();
			
		try
		{
			
			//ps=DbFactory.getMysqlConnection().prepareStatement("select l_of_acnts.ac_no,balance,from l_of_acnts where l_of_acnts.ac_no in (select ac_no from cstmr_details where cstmr_id=?) ");
			ps=DbFactory.getMysqlConnection().prepareStatement("select l_of_acnts.ac_no,balance from l_of_acnts where l_of_acnts.ac_no in(select ac_no from cstmr_details where cstmr_id=?) ");
			
			ps.setString(1, cstmrId);
		
		ResultSet rs = ps.executeQuery();
		Transaction transac ;
		while(rs.next())
		{
			transac=new Transaction();
			
			transac.setFrmAcNo(rs.getString(1));
			//transac.settAcNo(rs.getString(2));
			transac.setBalance(rs.getFloat(2));
			//transac.setMode(rs.getString(4));
			
			list.add(transac);
		}
		}catch(SQLException e){System.out.println(e);}
		catch(NumberFormatException e){}
		return list;
	}
	

	public void getAvlBalance(float avlBalance)
	{
		this.avlBalance=avlBalance;
	}
	
}
