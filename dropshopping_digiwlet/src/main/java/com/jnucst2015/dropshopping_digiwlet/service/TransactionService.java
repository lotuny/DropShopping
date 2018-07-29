package com.jnucst2015.dropshopping_digiwlet.service;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping_digiwlet.vo.TranVo;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransaction();

    Transaction getTransactionByID(Integer id);

    Transaction updateTransaction(Transaction transaction);

    void deleteByID(Integer id);

    Transaction addTransaction(Transaction transaction);

    List<TranVo> showAllTranVo();

    List<Transaction> getAllByPayerIdAndRole(Integer payerId, Integer payerRole);

    List<Transaction> getAllByRecipientIdAndRole(Integer recipientId, Integer recipientRole);

    List<TranVo> showAllVoByPayerIdAndRole(Integer payerId, Integer payerRole);

    List<TranVo> showAllVoByRecipientIdAndRole(Integer recipientId, Integer recipientRole);

    List<TranVo> showAllVoByUserIdAndRole(Integer userId, Integer userRole);

    TranVo fromTranToVo(Transaction tran);
}
