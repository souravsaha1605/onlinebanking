package com.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

public class Transaction {
	String frmAcNo;
	/*Timestamp date;
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	*/
	Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	float avlBalance;
	public float getAvlBalance() {
		return avlBalance;
	}
	public void setAvlBalance(float avlBalance) {
		this.avlBalance = avlBalance;
	}
	/*DateFormat date;
	
	public DateFormat getDate() {
		return date;
	}
	public void setDate(DateFormat date) {
		this.date = date;
	}
	*/
	public String getFrmAcNo() {
		return frmAcNo;
	}
	public void setFrmAcNo(String frmAcNo) {
		this.frmAcNo = frmAcNo;
	}
	public String gettAcNo() {
		return tAcNo;
	}
	public void settAcNo(String tAcNo) {
		this.tAcNo = tAcNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	String tAcNo;
	float balance;
	String mode;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
