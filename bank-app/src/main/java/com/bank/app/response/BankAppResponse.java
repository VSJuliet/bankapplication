package com.bank.app.response;

import com.bank.app.entity.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BankAppResponse {
	
	@JsonIgnore
	private Long id;
	private String accNumber;
	private String accHolderName;
	private String accType;
	private Double accBalance;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(Double accBalance) {
		this.accBalance = accBalance;
	}
	
	public BankAppResponse(String accNumber, String accHolderName, String accType, Double accBalance) {
		super();
		//this.id = id;
		this.accNumber = accNumber;
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankAppResponse");
		builder.append(" accNumber=");
		builder.append(accNumber);
		builder.append(", accHolderName=");
		builder.append(accHolderName);
		builder.append(", accType=");
		builder.append(accType);
		builder.append(", accBalance=");
		builder.append(accBalance);
		builder.append("]");
		return builder.toString();
	}
	
	public BankAppResponse (BankAccount account) {
		//this.id = account.getId();
		this.accNumber = account.getAccountNumber();
		this.accHolderName = account.getAccountHolderName();
		this.accType = account.getAccountType();
		this.accBalance = account.getBalance_amt();
	}
	
	

	
}
