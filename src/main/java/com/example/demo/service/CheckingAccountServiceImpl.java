package com.example.demo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BalanceDto;
import com.example.demo.dto.CheckingAccountDto;
import com.example.demo.exception.CheckingAccountException;
import com.example.demo.exception.ErrorCodeEnum;
import com.example.demo.exception.ErrorMessages;
import com.example.demo.mapper.CheckingAccountMapper;
import com.example.demo.model.AccountOperation;
import com.example.demo.model.CheckingAccount;
import com.example.demo.model.CheckingAccountHistory;
import com.example.demo.model.OverDraftHistory;
import com.example.demo.model.TypeOperationEnum;
import com.example.demo.repository.CheckingAccountHistoryRepository;
import com.example.demo.repository.CheckingAccountRepository;
import com.example.demo.util.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckingAccountServiceImpl implements CheckingAccountService {
	
	private final CheckingAccountRepository repository;
	private final CheckingAccountHistoryRepository checkingAccountHistoryRepository;
	private final CheckingAccountMapper mapper;
	
	@Override
	@Transactional
	public CheckingAccount createAccount() {

		return repository.save(CheckingAccount.generateCheckingAccount());
	}

	@Override
	@Transactional
	public void operation(BigInteger accountNumber, TypeOperationEnum typeOperation, BigDecimal value) {
		CheckingAccount checkingAccount = repository.findByNumber(accountNumber).orElseThrow(() -> {
			return new CheckingAccountException(ErrorCodeEnum.ACCOUNT_NOT_FOUND, ErrorMessages.NOT_FOUND,
					"Checking account not found.");
		});

		operationValidate(typeOperation, value, checkingAccount);

		AccountOperation.mountAccountOperation(typeOperation, value, checkingAccount);

		repository.saveAndFlush(checkingAccount);
		
	}

	private void operationValidate(TypeOperationEnum typeOperation, BigDecimal value, CheckingAccount checkingAccount) {
		if (typeOperation.equals(TypeOperationEnum.DEPOSIT)
				&& (value.compareTo(BigDecimal.ZERO) < 0 || value.compareTo(BigDecimal.ZERO) == 0)) {
			throw new CheckingAccountException(ErrorCodeEnum.VALIDATION_ERROR, ErrorMessages.BAD_REQUEST,
					"Deposit cannot be less than or equal to 0.");
		}

		if (typeOperation.equals(TypeOperationEnum.WITHDRAWAL)
				&& value.compareTo(checkingAccount.getBalance().add(checkingAccount.getOverDraft().getLimit())) > 0) {
			throw new CheckingAccountException(ErrorCodeEnum.VALIDATION_ERROR, ErrorMessages.BAD_REQUEST,
					"Withdraw more than available in the account + over draft.");
		}
	}
 

	@Override
	public BalanceDto findCheckingAccountBalance(BigInteger accountNumber, String date) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        final LocalDate localDate = Utils.extractDateFromPattern(date, formatter);
        
		Optional<ImmutablePair<CheckingAccountHistory, OverDraftHistory>> a = repository
				.findTopByNumberOrderByNumberDesc(accountNumber).map(pred -> {

					return ImmutablePair.of(pred.getCheckingAccountHistories().stream().filter(p -> {

						return p.getMovementAt()
								.isAfter(LocalDateTime
										.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0)
										.plusHours(0).plusMinutes(0).plusSeconds(1))
								&& p.getMovementAt().isBefore(LocalDateTime
										.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0)
										.plusHours(23).plusMinutes(59).plusSeconds(59));

					}).findFirst().orElse(
							pred.getCheckingAccountHistories().get(pred.getCheckingAccountHistories().size() - 1)),
							pred.getOverDraft().getOverDraftHistories().stream().filter(p -> {

								return p.getModificationAt().isAfter(LocalDateTime
										.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0)
										.plusHours(0).plusMinutes(0).plusSeconds(1))
										&& p.getModificationAt()
												.isBefore(LocalDateTime
														.of(localDate.getYear(), localDate.getMonth(),
																localDate.getDayOfMonth(), 0, 0)
														.plusHours(23).plusMinutes(59).plusSeconds(59));

							}).findFirst().orElse(pred.getOverDraft().getOverDraftHistories()
									.get(pred.getOverDraft().getOverDraftHistories().size() - 1)));
				});
		BalanceDto balanceDto = mapper.toBalanceDto(
				a.get().getLeft(), a.get().getRight(), accountNumber);
 
		return balanceDto;
	}

	@Override
	public List<CheckingAccountHistory> findCheckingAccountBankStatement(BigInteger accountNumber) { 
		return checkingAccountHistoryRepository.findFirst3ByCheckingAccountNumber(accountNumber);
	}
 
}
