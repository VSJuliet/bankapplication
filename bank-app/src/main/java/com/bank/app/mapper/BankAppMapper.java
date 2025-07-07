package com.bank.app.mapper;

import com.bank.app.entity.BankAccount;
import com.bank.app.request.BankAppRequest;
import com.bank.app.response.BankAppResponse;

public class BankAppMapper {
	
	public static BankAppRequest mapToBankAppRequest(BankAccount bankAccount) {
		return new BankAppRequest(
				bankAccount.getAccountNumber(),
				bankAccount.getAccountHolderName(),
				bankAccount.getAccountType(),
				bankAccount.getBalance_amt()
		);
	}
	
	public static BankAccount mapToBankAccount(BankAppRequest request) {
		return new BankAccount(
				request.getAccNumber(),
				request.getAccHolderName(),
				request.getAccType(),
				request.getAccBalance()
		);
	}
	
	public static BankAppResponse mapToBankAppResponse(BankAccount account) {
		return new BankAppResponse(
				account.getAccountNumber(),
				account.getAccountHolderName(),
				account.getAccountType(),
				account.getBalance_amt()
		);
	}
	

}
