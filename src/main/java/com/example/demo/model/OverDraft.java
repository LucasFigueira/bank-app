package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OVERDRAFT")
public class OverDraft {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OVERDRAFT")
    @SequenceGenerator(sequenceName = "SEQ_OVERDRAFT", allocationSize = 1, name = "SEQ_OVERDRAFT")
    private Integer id;
	
	@NotNull
    @Column(name = "LIMIT_OVERDRAFT")
    private BigDecimal limit = BigDecimal.ZERO;

	@ToString.Exclude
    @OneToMany(mappedBy = "overDraft", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OverDraftHistory> overDraftHistories = new ArrayList<>();

	public void addOverDraftHistories(final OverDraftHistory overDraftHistory) {
		OverDraftHistory overDraftHistoryJoin = new OverDraftHistory(overDraftHistory.getId(), limit, LocalDateTime.now(), this);

		overDraftHistories.add(overDraftHistoryJoin);
    }
	
	public OverDraft(OverDraftHistory overDraftHistory) {
		this.addOverDraftHistories(overDraftHistory);
	}
}
