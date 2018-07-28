package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
