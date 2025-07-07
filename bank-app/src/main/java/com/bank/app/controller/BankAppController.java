package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.response.BankAppResponse;
import com.bank.app.service.BankAppService;
import com.bank.app.entity.BankAccount;
import com.bank.app.request.BankAppRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/bank/")
public class BankAppController {
	
	@Autowired
	BankAppService bankAppService;

	@GetMapping("/getAll")
	public List<BankAppResponse> getAllAccounts() {
		//return bankAppService.getAllAccounts();
		List<BankAccount> accountList = bankAppService.getAllAccounts();
		List<BankAppResponse> responseList = new ArrayList<BankAppResponse>();
		
		accountList.stream().forEach(account -> {
			responseList.add(new BankAppResponse(account));
		});		
		return responseList;		
	}
	
	@GetMapping("/get/account/{accNum}")
	public BankAppResponse getByAccountNumber(@PathVariable String accNum) {		
		return bankAppService.getAccountByAccountNumber(accNum);
		
	}
	
	@PostMapping("/add")
    public BankAppResponse addAccount(@RequestBody BankAppRequest account) {		
		return bankAppService.addAccount(account);
    }
	
	@PutMapping("/deposit")
	public Map<String, Object> depositAmount(@RequestBody Map<String, Object> req) {
		String acctNum = (String) req.get("accNumber");
		Double amount = Double.parseDouble(req.get("accBalance").toString());
		BankAppResponse acc = bankAppService.deposit(acctNum, amount);
		if(acc != null) {
			return Map.of("message", "Successfully Deposited", "accNumber", acc.getAccNumber(), "currentBalance", acc.getAccBalance());
		} else {
			return Map.of("message", "No Account Found", "accNumber", acctNum);
		}
		
	}

	@PutMapping("/withdraw")
	public Map<String, Object> withdrawAmount(@RequestBody Map<String, Object> req) {
		String acctNum = (String) req.get("accNumber");
		Double amount = Double.parseDouble(req.get("accBalance").toString());
		BankAppResponse acc = bankAppService.withdraw(acctNum, amount);
		if(acc != null) {
			return Map.of("message", "Successfully Withdrawn", "accNumber", acc.getAccNumber(), "currentBalance", acc.getAccBalance());
		} else {
			return Map.of("message", "No Account Found", "accNumber", acctNum);
		}
		
	}
	
	@DeleteMapping("/delete/{accNum}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accNum) {
		bankAppService.deleteAccount(accNum);
        return ResponseEntity.noContent().build();
    } 

}
