package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.bank.app.entity.BankAccount;

import jakarta.persistence.LockModeType;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
	
	BankAccount findByAccountNumber(String accountNumber);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	BankAccount findWithLockingByAccountNumber(String bankAccountNumber);
	
}
