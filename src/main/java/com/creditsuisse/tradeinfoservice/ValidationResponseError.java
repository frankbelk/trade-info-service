package com.creditsuisse.tradeinfoservice;

public class ValidationResponseError {
	
	private String errorMsg;
	private String validationHandler;
	private String tradeData;
		
	public String getErrorMessage() {
		return this.errorMsg;
	}
	
	public void setErrorMsg(String errorMessage) {
		this.errorMsg = errorMessage;
	}
	
	public String getValidationHandler() {
		return this.validationHandler;
	}
	
	public void setValidationHandler(String handlername) {
		this.validationHandler = handlername;
	}
	
	public String getTradeData() {
		return this.tradeData;
	}
	
	public void setTradeData(String tradeData) {
		this.tradeData = tradeData;
	}

}
