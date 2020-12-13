package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CheckingAccountHistory;

public interface CheckingAccountHistoryRepository extends JpaRepository<CheckingAccountHistory, Integer>{
	List<CheckingAccountHistory> findFirst3ByCheckingAccountNumber(BigInteger number);
}
