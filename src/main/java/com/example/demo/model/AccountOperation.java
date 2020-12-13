package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ACCOUNT_OPERATION")
public class AccountOperation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT_OPERATION")
    @SequenceGenerator(sequenceName = "SEQ_ACCOUNT_OPERATION", allocationSize = 1, name = "SEQ_ACCOUNT_OPERATION")
    private Integer id;
	
	@Enumerated
    @Column(name = "TYPE")
	TypeOperationEnum typeOperationEnum;
	
	@NotNull
    @Column(name = "VALUE")
    private BigDecimal value;
	
	@Column(name = "OPERATION_AT", columnDefinition = "TIMESTAMP")
    protected LocalDateTime operationAt = LocalDateTime.now();
	
	@ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CHECKING_ACCOUNT_ID")
    private CheckingAccount checkingAccount;
	
	public static void mountAccountOperation(TypeOperationEnum typeOperation, BigDecimal value,
			CheckingAccount checkingAccount) {
		AccountOperation accountOperation = new AccountOperation();
		accountOperation.setCheckingAccount(checkingAccount);
		accountOperation.setValue(value);
		accountOperation.setTypeOperationEnum(typeOperation);
		checkingAccount
				.setBalance(typeOperation.equals(TypeOperationEnum.DEPOSIT) ? checkingAccount.getBalance().add(value)
						: checkingAccount.getBalance().subtract(value));
		CheckingAccountHistory checkingAccountHistory = new CheckingAccountHistory();
		checkingAccountHistory.setBalance(checkingAccount.getBalance());
		checkingAccount.addCheckingAccountHistories(checkingAccountHistory);
		checkingAccount.addAccountOperations(accountOperation);
	}
	
	
}
