package com.creditsuisse.tradeinfoservice.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.ValidationResponseError;
import com.creditsuisse.tradeinfoservice.TradeInfoBO;

public class CustomerValidationHandler extends AbstractValidationHandler {

	Logger LOG = Logger.getLogger(CustomerValidationHandler.class);
	final static String CLASSNAME = CustomerValidationHandler.class.getName();
	
	public enum Customers {
		PLUTO1,
		PLUTO2;
	}
	
	@Override
	public ValidationResponse validate(TradeInfoBO tradeData) {
		LOG.info(CLASSNAME + "I'm inside this class");
		
		List<ValidationResponseError> vrList = new ArrayList<>();
		ValidationResponseError vrError = new ValidationResponseError();
		
		String customer = tradeData.getCustomer();
		
		if (StringUtils.isBlank(customer)) {
			String customerEmpty = "Customer value was not provided";
			vrError.setErrorMsg(customerEmpty);
			
			LOG.error(customerEmpty);
			
			return null;
		}
		
		List<String> validCustomers = Stream.of(Customers.values())
				.map(Enum::name)
				.collect(Collectors.toList());
		
		if (!validCustomers.contains(customer)) {
			String invalidCustomer = String.format("Invalid Customer provided in the request %s ", customer) ;
			vrError.setErrorMsg(invalidCustomer);
			vrError.setTradeData(tradeData.getCustomer());
			
			LOG.error(invalidCustomer);
			
		} else {
			LOG.info("SUCCESS " + tradeData);
		}
		
		vrError.setValidationHandler(CLASSNAME);
		
		vrList.add(vrError);
		ValidationResponse vResp = new ValidationResponse();
		vResp.addCustomerHandler(vrList);
		
		return vResp;
		
	}
	
}
	
	
	

