package com.cg.wallet.exception;

/*****************************************************************************************************************************************************
 * @author      :  Parteek goel
 * Description  :  It is a exception class that is used to throw WalletAccountDoNotExistsException
 *                 when user add money and given phoneNo is not exists
 * Version      :  1.0
 * Created Date :  7-OCT-2020
 *****************************************************************************************************************************************************/

public class WalletAccountDoNotExistsException extends Exception {
	
	public WalletAccountDoNotExistsException() {
		super();
	}

	public WalletAccountDoNotExistsException(String message) {
		super(message);
	}

}
