package com.example.bank.controller;


import com.example.bank.dto.BankDto;
import com.example.bank.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("accounts/create-account")
    public BankDto createAccount(@RequestBody BankDto bankDto) {
        return bankService.addAccount(bankDto);
    }

    @GetMapping("/accounts/{account-id}")
    public BankDto getAccountById(@PathVariable("account-id") int id){
        return bankService.getAccountById(id);
    }

    @PostMapping("/accounts/deposit/{account-id}")
    public String deposit(@PathVariable("account-id") int id,@RequestBody Map<String,Double> request){
        return bankService.deposit(id,request.get("amount"));
    }

    @PostMapping("/accounts/withdraw/{account-id}")
    public String withdraw(@PathVariable("account-id") int id,@RequestBody Map<String,Double> request){
        return bankService.withdraw(id,request.get("amount"));
    }

    @GetMapping("accounts")
    public List<BankDto> getAllAccounts(){
        return bankService.getAll();
    }

    @GetMapping("/accounts/balance/{account-id}")
    public Double getAccountBalance(@PathVariable("account-id") int id){
        return bankService.getBalanceById(id);

    }


}
