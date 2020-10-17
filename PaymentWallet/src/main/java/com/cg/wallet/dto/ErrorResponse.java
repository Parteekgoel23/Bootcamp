package com.cg.wallet.dto;

/*******************************************************************************************************
 * @author      :  Parteek goel
 * Description  :  It is a dto class that is used to show the error response when there is an exception
 * Version      :  1.0
 * Created Date :  7-OCT-2020
 ********************************************************************************************************/

public class ErrorResponse {

	private String status;
	private String message;
	private String timeStamp;
	public ErrorResponse(String status, String message, String timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
