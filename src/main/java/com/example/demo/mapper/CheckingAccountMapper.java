package com.example.demo.mapper;

import java.math.BigInteger;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

import com.example.demo.dto.BalanceDto;
import com.example.demo.model.CheckingAccountHistory;
import com.example.demo.model.OverDraftHistory;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CheckingAccountMapper {

	@Mappings({
		@Mapping(source = "checkingAccountHistory", target = "checkingAccountDto"),
        @Mapping(source = "checkingAccountHistory.balance", target = "checkingAccountDto.balance"),
        @Mapping(source = "checkingAccountHistory.movementAt", target = "checkingAccountDto.balanceAt"),
        @Mapping(source = "overDraftHistory.limit", target = "overDraftDto.limit"),
        @Mapping(source = "overDraftHistory.modificationAt", target = "overDraftDto.overDraftAt")
	})
	BalanceDto toBalanceDto(CheckingAccountHistory checkingAccountHistory, OverDraftHistory overDraftHistory, BigInteger accountNumber);
}
