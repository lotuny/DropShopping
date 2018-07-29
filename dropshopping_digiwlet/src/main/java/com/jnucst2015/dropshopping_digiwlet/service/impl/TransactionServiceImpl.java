package com.jnucst2015.dropshopping_digiwlet.service.impl;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping.repository.TransactionRepository;
import com.jnucst2015.dropshopping_digiwlet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final Integer COMPANY = 0;
    public static final Integer SELLER = 1;
    public static final Integer CONSUMER = 2;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionByID(Integer id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteByID(Integer id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction addTransaction(Integer payer_id, Integer recipient_id, Integer price) {
        return null;
    }

    @Override
    public Transaction addTransaction() {
        return null;
    }
}
