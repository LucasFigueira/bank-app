package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BalanceDto {

	private CheckingAccountDto checkingAccountDto;
	private OverDraftDto overDraftDto;
}
