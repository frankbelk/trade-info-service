package com.creditsuisse.tradeinfoservice.validation;

import com.creditsuisse.tradeinfoservice.ValidationResponse;
import com.creditsuisse.tradeinfoservice.TradeInfoBO;

public abstract class AbstractValidationHandler {
	
	protected abstract ValidationResponse validate(TradeInfoBO tradeData);
	
}
	

