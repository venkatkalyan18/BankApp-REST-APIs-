package com.example.bank.mapper;
import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;
import org.springframework.stereotype.Service;


@Service
public class BankMapper {

    public BankDto toBankDto(Bank bank){
        BankDto bankDto = new BankDto();
        bankDto.setId(bank.getId());
        bankDto.setAccountHolderName(bank.getAccountHolderName());
        return bankDto;
    }

    public Bank toBank(BankDto bankDto){
        Bank bank = new Bank();
        bank.setId(bankDto.getId());
        bank.setAccountHolderName(bankDto.getAccountHolderName());
        return bank;
    }



}
