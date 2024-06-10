package com.example.bank.service;

import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;
import com.example.bank.mapper.BankMapper;
import com.example.bank.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    public BankService(BankRepository bankRepository, BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }

    public BankDto addAccount(BankDto bankDto){
        Bank bank = bankMapper.toBank(bankDto);
        Bank saved = bankRepository.save(bank);
        return bankMapper.toBankDto(saved);
    }

    public BankDto getAccountById(int id){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not available"));
        return bankMapper.toBankDto(bank);
    }


    public String deposit(int id,Double amount){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not available"));
        Double total = bank.getBalance() + amount;
        bank.setBalance(total);
        bankRepository.save(bank);
        return "Deposit Sucessfull";
    }

    public String withdraw(int id,Double amount){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not available"));

        if(amount > bank.getBalance()){
            return "Insufficient balance";
        }

        Double total = bank.getBalance() - amount;
        bank.setBalance(total);
        bankRepository.save(bank);
        return "Withdraw successful";
    }

    public List<BankDto> getAll(){
        List<Bank> banks = bankRepository.findAll();
        return banks
                .stream()
                .map(bankMapper::toBankDto)
                .collect(Collectors.toList());
    }

    public Double getBalanceById(int id){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not available"));
        return bank.getBalance();
    }






}
