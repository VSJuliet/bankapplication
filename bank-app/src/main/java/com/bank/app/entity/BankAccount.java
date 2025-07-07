package com.bank.app.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@Table(name="bank_accounts")
public class BankAccount {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonProperty("accountNumber")
    @Column(name="account_number", unique=true)
    private String accountNumber;
    
	@JsonProperty("accountHolderName")
    @Column(name="account_holder_name")
    private String accountHolderName;

	@JsonProperty("accountType")
    @Column(name="account_type")
    private String accountType;
    
	@JsonProperty("accountBalane")
    @Column(name="balance_amt")
    private Double balance_amt;
    
	@CreationTimestamp
    @Column(name="created_date")    
    private LocalDateTime createdAt;

 	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance_amt() {
		return balance_amt;
	}

	public void setBalance_amt(Double balance_amt) {
		this.balance_amt = balance_amt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public BankAccount() {
		// Default constructor
	}

	public BankAccount(String accountNumber, String accountHolderName, String accountType, Double balance_amt) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.balance_amt = balance_amt;
	}

	public BankAccount(Long id, String accountNumber, String accountHolderName, String accountType, Double balance_amt,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.balance_amt = balance_amt;
		this.createdAt = createdAt;
	}

	
	
	    
}
