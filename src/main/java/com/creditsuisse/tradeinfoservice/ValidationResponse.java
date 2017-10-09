package com.creditsuisse.tradeinfoservice;

import java.util.ArrayList;
import java.util.List;


public class ValidationResponse {
	
	private List<ValidationResponseError> customerList;
	private List<ValidationResponseError> dateList;
	private List<ValidationResponseError> optionsList;
	private List<ValidationResponseError> productList;
	
	private List<String> errorList = new ArrayList<String>();
	
	public void addError(String error) {
		this.errorList.add(error);
	}
	
	public void addCustomerHandler(List<ValidationResponseError> vrList) {
		
		this.customerList = vrList;
		
	}
	
	public List<ValidationResponseError> getCustomerList() {
		return this.customerList;
	}
	
	public void addDateHandler(List<ValidationResponseError> vrList) {
		
		this.dateList = vrList;
		
	}
	
	public List<ValidationResponseError> getDateList() {
		return this.dateList;
	}
	
	public void addOptionsHandler(List<ValidationResponseError> vrList) {
		
		this.optionsList = vrList;
		
	}
	
	public List<ValidationResponseError> getOptionsList() {
		return this.optionsList;
	}
	
	public void addProductHandler(List<ValidationResponseError> vrList) {
		
		this.productList = vrList;
		
	}
	
	public List<ValidationResponseError> getProductList() {
		return this.productList;
	}

}
