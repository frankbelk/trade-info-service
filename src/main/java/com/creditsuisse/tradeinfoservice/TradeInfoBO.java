package com.creditsuisse.tradeinfoservice;

import java.math.BigDecimal;
import java.util.Date;

public class TradeInfoBO {

	String customer;
	String ccyPair;
	String direction;
	Date tradeDate;
	BigDecimal amount1;
	BigDecimal amount2;
	BigDecimal rate;
	Date valueDate;
	String legalEntity;
	String trader;
	String style;
	String strategy;
	Date deliveryDate;
	Date expiryDate;
	String payCcy;
	BigDecimal premium;
	String premiumType;
	Date premiumDate;
	String type;
	Date exerciseDate;
	
	
	public Date getExerciseDate() {
		return exerciseDate;
	}
	public void setExerciseDate(Date exerciseDate) {
		this.exerciseDate = exerciseDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public BigDecimal getAmount1() {
		return amount1;
	}
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	public BigDecimal getAmount2() {
		return amount2;
	}
	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPayCcy() {
		return payCcy;
	}
	public void setPayCcy(String payCcy) {
		this.payCcy = payCcy;
	}
	public BigDecimal getPremium() {
		return premium;
	}
	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}
	public String getPremiumType() {
		return premiumType;
	}
	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}
	public Date getPremiumDate() {
		return premiumDate;
	}
	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getCcyPair() {
		return ccyPair;
	}
	
	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}
	
	
}
