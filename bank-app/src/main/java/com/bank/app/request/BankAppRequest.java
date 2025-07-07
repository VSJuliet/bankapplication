package com.bank.app.request;

public class BankAppRequest {
	
	private String accNumber;
	private String accHolderName;
	private String accType;
	private Double accBalance;
	
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
	
	public BankAppRequest(String accNumber, String accHolderName, String accType, Double accBalance) {
		super();
		this.accNumber = accNumber;
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankAppRequest ");
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
	
	
	
	
	

}
