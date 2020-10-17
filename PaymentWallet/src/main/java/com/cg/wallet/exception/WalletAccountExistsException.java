package com.cg.wallet.exception;

/*****************************************************************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a exception class that is used to throw WalletAccountExistsException,
*                 when user create new wallet account and given phoneNo is already exits
* Version      :  1.0
* Created Date :  7-OCT-2020
*****************************************************************************************************************************************************/

public class WalletAccountExistsException extends Exception {

	public WalletAccountExistsException() {
		super();
	}
	
	public WalletAccountExistsException(String message) {
		super(message);	
	}	
}
