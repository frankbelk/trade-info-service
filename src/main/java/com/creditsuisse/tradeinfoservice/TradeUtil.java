package com.creditsuisse.tradeinfoservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class TradeUtil {
	static Logger LOG = Logger.getLogger(TradeUtil.class);
	final String CLASSNAME = TradeUtil.class.getName();
	
	/**
	 * Utility method responsible to format the {@linkplain Date} object to
	 * {@linkplain String} object in the <b>YYYY-MM-dd</b> format
	 * 
	 * @param date
	 * @return String date
	 */
	public static String date2String(Date date) {
		final String methodName = ".date2String";
		String strDate;
		
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("CEST"));
		strDate = df.format(date);
		
		LOG.info(methodName + " String date " + strDate);
		
		return strDate;
	}
	
	/**
	 * Calls the fixer.io REST service
	 * @param valueDate
	 * @param currency
	 * @return
	 */
	public static FixerBO callFixerIOSvc(String valueDate, String currency) {
		FixerBO fixerResp = null;
		
		if (valueDate == null) {
			LOG.error("value date object cannot be NULL");
			return null;
		}
		
		if (currency == null) {
			LOG.error("currency date object cannot be NULL");
			return null;
		}
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			fixerResp = restTemplate.getForObject("http://api.fixer.io/" + valueDate + "?base=" +currency , FixerBO.class);
			
		} catch (HttpClientErrorException hceEx) {
			LOG.error("Failed to parse response from Fixer.io", hceEx);
		}
        
        return fixerResp;
	}

}
