package com.bank.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.entity.ATMTransactions;
import com.bank.app.entity.BankAccount;
import com.bank.app.mapper.BankAppMapper;
import com.bank.app.repository.ATMTransactionRepository;
import com.bank.app.repository.BankAccountRepository;
import com.bank.app.request.BankAppRequest;
import com.bank.app.response.BankAppResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BankAppService {

	@Autowired
	BankAccountRepository accountRepo;
	
	@Autowired
	ATMTransactionRepository transactionRepo;
	
	public List<BankAccount> getAllAccounts() {
		return accountRepo.findAll();
	}
	
	public BankAppResponse getAccountByAccountNumber(String accountNumber) {
		return BankAppMapper.mapToBankAppResponse(accountRepo.findByAccountNumber(accountNumber));
	}

	public BankAppResponse addAccount(BankAppRequest accountReq) {
		BankAccount account = accountRepo.save(BankAppMapper.mapToBankAccount(accountReq));
		return BankAppMapper.mapToBankAppResponse(account);		 
	}

	public BankAppResponse deposit1(String acctNum, Double amount) {
		BankAppResponse response = null;
		BankAccount account = accountRepo.findByAccountNumber(acctNum);
		if(account!=null) {
			account.setBalance_amt(account.getBalance_amt() + amount);
			response = BankAppMapper.mapToBankAppResponse(accountRepo.save(account));
		} 
		return response;
	}
	
	public BankAppResponse withdraw1(String acctNum, Double amount) {
		BankAppResponse response = null;
		BankAccount account = accountRepo.findByAccountNumber(acctNum);
		if(account!=null) {
			account.setBalance_amt(account.getBalance_amt() - amount);
			response = BankAppMapper.mapToBankAppResponse(accountRepo.save(account));
		} 
		return response;
	}
	
	public BankAppResponse deposit(String bankAccountNumber, Double amount) {

		BankAccount bankAcct = accountRepo.findWithLockingByAccountNumber(bankAccountNumber);
		BankAppResponse response = null;
		if (bankAcct != null) {
			bankAcct.setBalance_amt(Double.sum(amount, bankAcct.getBalance_amt()));
			bankAcct = accountRepo.save(bankAcct);

			ATMTransactions atmTransaction = new ATMTransactions();
			atmTransaction.setBankAccountId(bankAcct);
			atmTransaction.setTransactionAmount(amount);
			atmTransaction.setTransactionType("deposit");
			transactionRepo.save(atmTransaction);

			// send to queue
			return BankAppMapper.mapToBankAppResponse(bankAcct);
		}
		return response;
	}
	
	public BankAppResponse withdraw(String bankAccountNumber, Double amount) {

		BankAccount bankAcct = accountRepo.findWithLockingByAccountNumber(bankAccountNumber);
		BankAppResponse response = null;
		if (bankAcct != null) {
			if (bankAcct.getBalance_amt().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient funds");
            }
			bankAcct.setBalance_amt(bankAcct.getBalance_amt() - amount);
			bankAcct = accountRepo.save(bankAcct);

			ATMTransactions atmTransaction = new ATMTransactions();
			atmTransaction.setBankAccountId(bankAcct);
			atmTransaction.setTransactionAmount(amount);
			atmTransaction.setTransactionType("withdrawal");
			transactionRepo.save(atmTransaction);

			// send to queue
			return BankAppMapper.mapToBankAppResponse(bankAcct);
		}
		return response;
	}

	public void deleteAccount(String accountNumber) {
		BankAccount account = accountRepo.findByAccountNumber(accountNumber);
		if(account != null) {
			accountRepo.deleteById(account.getId());
		} else {
			throw new RuntimeException("No Account Found - Delete Account Failed");
		}		
    }
	
}
