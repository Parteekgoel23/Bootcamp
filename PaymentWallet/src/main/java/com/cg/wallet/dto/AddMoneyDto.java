package com.cg.wallet.dto;

/****************************************************************************************
 * @author      :  Parteek goel
 * Description  :  It is a dto class that is used to add money in user's account
 * Version      :  1.0
 * Created Date :  7-OCT-2020
 ****************************************************************************************/

public class AddMoneyDto {
	
	private String  phoneNo;
	private double amount;
	@Override
	public String toString() {
		return "AddMoneyDto [phoneNo=" + phoneNo + ", amount=" + amount + "]";
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPhoneNo() {
		
		return phoneNo;
	}
	
}
