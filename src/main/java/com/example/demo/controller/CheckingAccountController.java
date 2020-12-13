package com.example.demo.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.BalanceDto;
import com.example.demo.dto.CheckingAccountDto;
import com.example.demo.model.CheckingAccount;
import com.example.demo.model.CheckingAccountHistory;
import com.example.demo.model.TypeOperationEnum;
import com.example.demo.service.CheckingAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
@Api(tags = "/v1/account", value = "Grupo de API's para manipulação de operações de conta corrente")
public class CheckingAccountController {

	private final CheckingAccountService checkingAccountService;
	
	@ApiOperation(value = "API para criar uma conta")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Conta criada"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @PostMapping(value = "/account")
    public ResponseEntity<CheckingAccount> findById() {
		CheckingAccount account = checkingAccountService.createAccount();
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/account")
                .buildAndExpand(account).toUri();
		
        return ResponseEntity.created(location).body(account);
    }
	
	@ApiOperation(value = "Endpoint para operações da conta")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Conta criada"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @PostMapping(value = "/account/operation")
	public ResponseEntity<Void> operation(@RequestParam BigInteger accountNumber,
			@RequestParam TypeOperationEnum typeOperation, @RequestParam BigDecimal value) {
		 checkingAccountService.operation(accountNumber, typeOperation, value);
		
		return ResponseEntity.status(HttpStatus.OK).build();
    }
	
	@ApiOperation(value = "Endpoint para operações da conta")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Conta criada"),
           @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/account/balance")
    public ResponseEntity<BalanceDto> findCheckingAccountBalance(@RequestParam BigInteger accountNumber, @RequestParam String date) {
		BalanceDto balanceDto = checkingAccountService.findCheckingAccountBalance(accountNumber, date);
		return ResponseEntity.ok(balanceDto);
    }
	
	@ApiOperation(value = "Endpoint para operações da conta")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Conta criada"),
           @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/account/balance/getAll")
    public ResponseEntity<List<CheckingAccountHistory>> findCheckingAccountBankStatement(@RequestParam BigInteger accountNumber) {
		List<CheckingAccountHistory> checkingAccountDto = checkingAccountService.findCheckingAccountBankStatement(accountNumber);
		return ResponseEntity.ok(checkingAccountDto);
    }
 
}
