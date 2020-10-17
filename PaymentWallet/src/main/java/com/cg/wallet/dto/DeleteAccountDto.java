package com.cg.wallet.dto;


/****************************************************************************************
 * @author      :  Parteek goel
 * Description  :  It is a dto class that is used to delete user's account
 * Version      :  1.0
 * Created Date :  12-OCT-2020
 ****************************************************************************************/

public class DeleteAccountDto {
	private String phoneNo;

	@Override
	public String toString() {
		return "DeleteAccountDto [phoneNo=" + phoneNo + "]";
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
