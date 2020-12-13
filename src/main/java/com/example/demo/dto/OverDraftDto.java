package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OverDraftDto {

	private BigDecimal limit;
	private LocalDateTime overDraftAt;
}
