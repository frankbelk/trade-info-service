package com.creditsuisse.tradeinfoservice.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import com.creditsuisse.tradeinfoservice.TradeInfoBO;
import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.ValidationResponseError;

public class OptionsValidationHandler extends AbstractValidationHandler {
	
Logger LOG = Logger.getLogger(OptionsValidationHandler.class);
final String CLASSNAME = OptionsValidationHandler.class.getName();
	
	public enum Styles {
		AMERICAN,
		EUROPEAN;
	}
	
	@Override
	public ValidationResponse validate(TradeInfoBO tradeData) {
		LOG.info(CLASSNAME + "I'm inside this class");
		ValidationResponse vrResp = this.validateOptions(tradeData);
		
		return vrResp;
		
	}
	
	private ValidationResponse validateOptions(TradeInfoBO tradeData) {
		
		List<ValidationResponseError> vrList = new ArrayList<>();
		ValidationResponseError vrError = new ValidationResponseError();

		String style = tradeData.getStyle();
		List<String> validOptions = Stream.of(Styles.values())
				.map(Enum::name)
				.collect(Collectors.toList());
		
		if (StringUtils.isBlank(style)) {
			vrError.setErrorMsg("Style is EMPTY");
			vrError.setTradeData(style);
			
			LOG.error("Style field is empty on request");
		}
		
		if (!validOptions.contains(style)) {
			LOG.error("Invalid Style provided in the request " + style);
			
		}
		
		Date expiryDate = tradeData.getExpiryDate();
		String isAmericanStyle = Styles.AMERICAN.toString();
		if (StringUtils.equalsIgnoreCase(style, isAmericanStyle)) {
			Date exerciseDate = tradeData.getExerciseDate();
			
			Date tradeDate = tradeData.getTradeDate();
			if (exerciseDate.after(tradeDate) && exerciseDate.before(expiryDate)) {
				vrError.setErrorMsg("the excerciseStartDate has to be after the trade date");
				
				String strExpiryDate = expiryDate.toString();
				String strExerciseDate = exerciseDate.toString();
				vrError.setTradeData("ExerciseDate " + strExerciseDate + " ExpiryDate " + strExpiryDate);
				
			}
			
			if (!tradeDate.before(exerciseDate)) {
				vrError.setErrorMsg("exerciseStartDate needs to be before the expiry date ");
			}
		}
		
		Date deliveryDate = tradeData.getDeliveryDate();
		if (!expiryDate.before(deliveryDate) 
				&& !tradeData.getPremiumDate().before(deliveryDate)) {
		}
		
		vrError.setValidationHandler(CLASSNAME);
		vrList.add(vrError);
		
		ValidationResponse vResp = new ValidationResponse();
		vResp.addOptionsHandler(vrList);

		return vResp;
	}
	
	
	

}
