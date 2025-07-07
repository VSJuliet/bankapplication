package com.bank.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "ATM_TRANSACTIONS")
public class ATMTransactions {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "BANKACCOUNT_ID", nullable = false)
	    private BankAccount bankAccountId;
	    
	    @CreationTimestamp
	    @Column(name="TRANSACTION_DATE", nullable = false)
	    private LocalDateTime createdAt;
	    
	    @Column(name="TRNSACTION_TYPE", nullable = false)
	    private String transactionType; 

	    @Column(name="TRANSACTION_AMT", nullable = false)
	    private Double transactionAmount;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public BankAccount getBankAccountId() {
			return bankAccountId;
		}

		public void setBankAccountId(BankAccount bankAccountId) {
			this.bankAccountId = bankAccountId;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		public Double getTransactionAmount() {
			return transactionAmount;
		}

		public void setTransactionAmount(Double transactionAmount) {
			this.transactionAmount = transactionAmount;
		}

	        
	
}
