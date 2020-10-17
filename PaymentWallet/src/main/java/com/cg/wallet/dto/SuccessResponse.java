package com.cg.wallet.dto;

/***********************************************************************************************************
 * @author      :  Parteek goel
 * Description  :  It is a dto class that is used to give success response when action perform succesfully
 * Version      :  1.0
 * Created Date :  7-OCT-2020
 ***********************************************************************************************************/

public class SuccessResponse {

	public String message;

	public SuccessResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
