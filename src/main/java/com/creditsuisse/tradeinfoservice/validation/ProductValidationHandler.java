package com.creditsuisse.tradeinfoservice.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.creditsuisse.tradeinfoservice.TradeInfoBO;
import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.ValidationResponseError;

public class ProductValidationHandler extends AbstractValidationHandler {
	Logger LOG = Logger.getLogger(ProductValidationHandler.class);
	final String CLASSNAME = ProductValidationHandler.class.getName();

	@Override
	public ValidationResponse validate(TradeInfoBO tradeData) {
		LOG.info(CLASSNAME + "I'm inside this class");
		
		List<ValidationResponseError> vrList = new ArrayList<>();
		ValidationResponseError vrError = new ValidationResponseError();
		
		vrError.setErrorMsg("Inside Product Handler Test");
		vrList.add(vrError);
		
		ValidationResponse vResp = new ValidationResponse();
		vResp.addProductHandler(vrList);
		
		return vResp;
	}

}
