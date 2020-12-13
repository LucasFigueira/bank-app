package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "CHECKING_ACCOUNT_HISTORY")
public class CheckingAccountHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHECKING_ACCOUNT_HISTORY")
	@SequenceGenerator(sequenceName = "SEQ_CHECKING_ACCOUNT_HISTORY", allocationSize = 1, name = "SEQ_CHECKING_ACCOUNT_HISTORY")
	private Integer id;
	
	@Column(name = "MOVEMENT_AT", columnDefinition = "TIMESTAMP")
    protected LocalDateTime movementAt = LocalDateTime.now();
	
	@NotNull
    @Column(name = "BALANCE")
    private BigDecimal balance = BigDecimal.ZERO;
	
	@ToString.Exclude
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHECKING_ACCOUNT_ID")
    private CheckingAccount checkingAccount;
	
}
