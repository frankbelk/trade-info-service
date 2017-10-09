package com.creditsuisse.tradeinfoservice.validation;

import java.util.HashMap;
import java.util.Map;

import com.creditsuisse.tradeinfoservice.TradeInfoBO;
import com.creditsuisse.tradeinfoservice.ValidationResponse;

public class ValidationFactory {
	
	public Map<Object, ValidationResponse> execute(TradeInfoBO tradeData){
		Map<Object, ValidationResponse> rMap = new HashMap<>();
		
		AbstractValidationHandler customerValidation = new CustomerValidationHandler();
		AbstractValidationHandler dateValidation = new DateValidationHandler();
		AbstractValidationHandler optionsValidation = new OptionsValidationHandler();
		AbstractValidationHandler productValidation = new ProductValidationHandler();
		AbstractValidationHandler currencyValidation = new CurrencyValidationHandler();
		
		rMap.put(customerValidation, customerValidation.validate(tradeData));
		rMap.put(dateValidation, dateValidation.validate(tradeData));
		rMap.put(optionsValidation, optionsValidation.validate(tradeData));
		rMap.put(productValidation, productValidation.validate(tradeData));
		rMap.put(currencyValidation, currencyValidation.validate(tradeData));
		
		return rMap;
		
	}
	
}
