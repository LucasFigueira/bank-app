package com.example.demo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.example.demo.dto.BalanceDto;
import com.example.demo.model.CheckingAccount;
import com.example.demo.model.CheckingAccountHistory;
import com.example.demo.model.TypeOperationEnum;

public interface CheckingAccountService {

	CheckingAccount createAccount();
		
	void operation(BigInteger accountNumber, TypeOperationEnum typeOperation, BigDecimal value);

	BalanceDto findCheckingAccountBalance(BigInteger accountNumber, String date);
	
	List<CheckingAccountHistory> findCheckingAccountBankStatement(BigInteger accountNumber);
}
