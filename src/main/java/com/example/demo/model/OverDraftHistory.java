package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
@AllArgsConstructor
@Entity(name = "OVERDRAFT_HISTORY")
public class OverDraftHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OVERDRAFT_HISTORY")
    @SequenceGenerator(sequenceName = "SEQ_OVERDRAFT_HISTORY", allocationSize = 1, name = "SEQ_OVERDRAFT_HISTORY")
    private Integer id;
	
	@NotNull
    @Column(name = "LIMIT_OVERDRAFT")
    private BigDecimal limit = BigDecimal.ZERO;
	
	@Column(name = "MODIFICATION_AT", columnDefinition = "TIMESTAMP")
    protected LocalDateTime modificationAt = LocalDateTime.now();
	
	@ToString.Exclude
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OVER_DRAFT_ID")
    private OverDraft overDraft;
}
