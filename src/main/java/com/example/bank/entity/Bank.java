package com.example.bank.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Bank {

    public Bank() {}

    @Id
    @GeneratedValue
    private int id;

    @Column(name="account_holder_name")
    private String AccountHolderName;

    private Double balance = 0.0;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
