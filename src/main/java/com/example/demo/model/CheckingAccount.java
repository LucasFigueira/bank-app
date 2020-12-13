package com.example.demo.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity(name = "CHECKING_ACCOUNT")
public class CheckingAccount {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHECKING_ACCOUNT")
    @SequenceGenerator(sequenceName = "SEQ_CHECKING_ACCOUNT", allocationSize = 1, name = "SEQ_CHECKING_ACCOUNT")
    private Integer id;
	
	@NotNull
    @Column(name = "NUMBER_ACCOUNT", columnDefinition = "BigInt")
    private BigInteger number = BigInteger.ONE;
	
	@NotNull
    @Column(name = "BALANCE_ACCOUNT")
    private BigDecimal balance = BigDecimal.ZERO;
	 
	@Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP")
    protected LocalDateTime createdAt = LocalDateTime.now();
	
	@ToString.Exclude
    @OneToMany(mappedBy = "checkingAccount", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AccountOperation> accountOperations = new ArrayList<>();
	
	@ToString.Exclude
    @OneToMany(mappedBy = "checkingAccount", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CheckingAccountHistory> checkingAccountHistories = new ArrayList<>();
	
	@ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OVERDRAFT_ID")
    private OverDraft overDraft;

    public void addAccountOperations(final AccountOperation accountOperation) {
		AccountOperation accountOperationJoin = new AccountOperation(accountOperation.getId(),
				accountOperation.getTypeOperationEnum(), accountOperation.getValue(), accountOperation.getOperationAt(), this);

    	accountOperations.add(accountOperationJoin);
    }
    
	public void addCheckingAccountHistories(final CheckingAccountHistory checkingAccountHistory) {
		CheckingAccountHistory checkingAccountHistoryJoin = new CheckingAccountHistory(checkingAccountHistory.getId(),
				checkingAccountHistory.getMovementAt(), checkingAccountHistory.getBalance(), this);
		checkingAccountHistories.add(checkingAccountHistoryJoin);
	}
    
    public CheckingAccount(OverDraft overDraft) {
    	this.overDraft = overDraft;
    	this.number = new BigInteger(String.valueOf(new Random().nextInt(777)));
    	this.addCheckingAccountHistories(new CheckingAccountHistory());
    }
    
	public static CheckingAccount generateCheckingAccount() {
		return new CheckingAccount(new OverDraft(new OverDraftHistory()));
	}
}
