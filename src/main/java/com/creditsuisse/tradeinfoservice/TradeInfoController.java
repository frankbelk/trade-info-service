package com.creditsuisse.tradeinfoservice;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditsuisse.tradeinfoservice.validation.ValidationFactory;

@RestController
public class TradeInfoController {
    @RequestMapping("/tradeInfoService")
    public void tradeInfoService(@RequestBody TradeInfoBO bean) {
    	
    	ValidationFactory validate = new ValidationFactory();
    	Map<Object, ValidationResponse> vrMap = validate.execute(bean);
    	
    }
}