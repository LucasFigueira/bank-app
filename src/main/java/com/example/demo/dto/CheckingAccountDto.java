package com.example.demo.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CheckingAccountDto {

    private BigDecimal balance;
    private BigInteger number;
    private LocalDateTime balanceAt;
}
