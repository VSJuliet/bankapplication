package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.entity.ATMTransactions;


@Repository
public interface ATMTransactionRepository extends JpaRepository<ATMTransactions, Long> {	

}
