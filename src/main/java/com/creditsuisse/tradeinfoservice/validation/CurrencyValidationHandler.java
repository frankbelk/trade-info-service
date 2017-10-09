package com.creditsuisse.tradeinfoservice.validation;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.creditsuisse.tradeinfoservice.FixerBO;
import com.creditsuisse.tradeinfoservice.TradeInfoBO;
import com.creditsuisse.tradeinfoservice.TradeUtil;
import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.ValidationResponseError;

public class CurrencyValidationHandler extends AbstractValidationHandler {
	Logger LOG = Logger.getLogger(CurrencyValidationHandler.class);
	final String CLASSNAME = CurrencyValidationHandler.class.getName();

	@Override
	public ValidationResponse validate(TradeInfoBO tradeData) {
		LOG.info(CLASSNAME + "I'm inside this class");
		
		List<ValidationResponseError> vrList = new ArrayList<>();
		ValidationResponseError vrError = new ValidationResponseError();
		
		Date valueDate = tradeData.getValueDate();
		String payCcy = tradeData.getPayCcy();
		String strValueDate = null;
		
		if (valueDate == null) {
			vrError.setErrorMsg("Value date cannot be NULL");
		}
		
		if (payCcy == null) {
			vrError.setErrorMsg("payCcy cannot be NULL");
		}
		
		strValueDate = TradeUtil.date2String(valueDate);
		FixerBO fixerSvc = TradeUtil.callFixerIOSvc(strValueDate, payCcy);
		Date fixerDate = fixerSvc.getDate();
		String strFixerDate = TradeUtil.date2String(fixerDate);
		
		
		if (!isWeekendOrHoliday(strValueDate, strFixerDate)) {
			String errorMsg = "valueDate " + strValueDate + " is not a WEEK DAY";
			LOG.error(errorMsg);
			
			vrError.setErrorMsg(errorMsg);
		}
				
		if (!isCurrencyValid(payCcy)) {
			String errorMsg = "currency " + payCcy + " is not valid";
			LOG.error(errorMsg);
			
			vrError.setErrorMsg(errorMsg);
		}
		
		ValidationResponse vResp = new ValidationResponse();
		
		vrError.setValidationHandler(CLASSNAME);
		vrList.add(vrError);
		vResp.addDateHandler(vrList);
		
		return vResp;
	}

	private boolean isCurrencyValid(String payCcy) {
		boolean isCurrencyValid = false;
		
		try {
			Currency curr = Currency.getInstance(payCcy);
			
			if (curr != null) {
				isCurrencyValid = true;
			}
			
		} catch (IllegalArgumentException iaEx) {
			return isCurrencyValid;
		}
		
		return isCurrencyValid;
	}

	/**
	 * Inspector method to validate if <b>valueDate</b> is weekend day or holiday.
	 * @param strValueDate
	 * @param strFixerDate
	 * @return boolean isWeekendOrHoliday
	 */
	private boolean isWeekendOrHoliday(String strValueDate, String strFixerDate) {
		boolean isWeekendOrHoliday = false;
		
		if (!StringUtils.equalsIgnoreCase(strValueDate, strFixerDate)) {
			return isWeekendOrHoliday = true;
		}
		
		return isWeekendOrHoliday;
	}
	
}
