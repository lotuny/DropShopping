package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransaction();

    Transaction getTransactionByID(Integer id);

    Transaction updateTransaction(Transaction transaction);

    void deleteByID(Integer id);

    Transaction addTransaction(Transaction transaction);

    Transaction addTransaction(Integer payer_id, Integer recipient_id, Integer price);

    Transaction addTransaction();
}
