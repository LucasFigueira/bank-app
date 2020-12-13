package com.example.demo.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer>{

	Optional<CheckingAccount> findByNumber(BigInteger accountNumber);
	
	Optional<CheckingAccount> findTopByNumberOrderByNumberDesc(BigInteger accountNumber);

	Optional<CheckingAccount> findTopByNumberAndCheckingAccountHistoriesMovementAtBetweenOrderByCheckingAccountHistoriesMovementAtAsc(
			BigInteger accountNumber, LocalDateTime startDate, LocalDateTime finalDate);

	CheckingAccount findTopByNumberOrderByCheckingAccountHistoriesMovementAtAsc(BigInteger accountNumber);
	
	

}
