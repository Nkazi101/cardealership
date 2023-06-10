package com.cardealership.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealership.models.Transaction;
import com.cardealership.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction>getAllTransactions(){
        return transactionRepository.findAll();
    }
    
}
