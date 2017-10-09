package com.creditsuisse.tradeinfoservice.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.creditsuisse.tradeinfoservice.TradeInfoBO;
import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.ValidationResponseError;

public class DateValidationHandler extends AbstractValidationHandler {
	
	Logger LOG = Logger.getLogger(DateValidationHandler.class);
	final String CLASSNAME = DateValidationHandler.class.getName();

	@Override
	public ValidationResponse validate(TradeInfoBO tradeData) {
		LOG.info(CLASSNAME + "I'm inside this class");
		
		List<ValidationResponseError> vrList = new ArrayList<>();
		ValidationResponseError vrError = new ValidationResponseError();
		
		Date valueDate = tradeData.getValueDate();
		Date tradeDate = tradeData.getTradeDate();
		
		if (valueDate == null) {
			vrError.setErrorMsg("Object valueDate is NULL");
		}
		
		if (tradeDate == null) {
			vrError.setErrorMsg("Object tradeDate is NULL");
		}
		
		
		if (valueDate.before(tradeDate)) {
			String dateError = "Value date " + valueDate + " cannot be before trade date " + tradeDate;
			vrError.setErrorMsg("Value date cannot be before trade date");
			
			String strValueDate = tradeData.getValueDate().toString();
			String strTradeDate = tradeData.getTradeDate().toString();
			vrError.setTradeData("Value date " + strValueDate + " Trade date " + strTradeDate);
			
			LOG.error(dateError);
		}
		
		vrError.setValidationHandler(CLASSNAME);
		
		vrList.add(vrError);
		
		ValidationResponse vResp = new ValidationResponse();
		vResp.addDateHandler(vrList);
		
		return vResp;

	}

}
