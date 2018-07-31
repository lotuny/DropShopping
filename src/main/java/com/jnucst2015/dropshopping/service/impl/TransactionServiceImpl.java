package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping.repository.CompanyRepository;
import com.jnucst2015.dropshopping.repository.SellerRepository;
import com.jnucst2015.dropshopping.repository.TransactionRepository;
import com.jnucst2015.dropshopping.service.TransactionService;
import com.jnucst2015.dropshopping.vo.TranVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final Integer COMPANY = 0;
    public static final Integer SELLER = 1;
    public static final Integer CONSUMER = 2;
    public static final Integer PLATFORM = 3;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private SellerRepository sellerRepository;

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
    public List<TranVo> showAllTranVo() {
        List<Transaction> allTran = transactionRepository.findAll();
        List<TranVo> allTranVo = new ArrayList<>();

        for (int i = 0; i < allTran.size(); i++) {
            allTranVo.add(fromTranToVo(allTran.get(i)));
        }

        return allTranVo;
    }

    @Override
    public List<Transaction> getAllByPayerIdAndRole(Integer payerId, Integer payerRole) {
        return transactionRepository.getAllByPayer_idaAndPayer_role(payerId, payerRole);
    }

    @Override
    public List<Transaction> getAllByRecipientIdAndRole(Integer recipientId, Integer recipientRole) {
        return transactionRepository.getAllByRecipient_idAndRecipient_role(recipientId, recipientRole);
    }

    @Override
    public List<TranVo> showAllVoByPayerIdAndRole(Integer payerId, Integer payerRole) {
        List<Transaction> allTran = getAllByPayerIdAndRole(payerId, payerRole);
        List<TranVo> allTranVo = new ArrayList<>();

        for (int i = 0; i < allTran.size(); i++) {
            allTranVo.add(fromTranToVo(allTran.get(i)));
        }

        return allTranVo;
    }

    @Override
    public List<TranVo> showAllVoByRecipientIdAndRole(Integer recipientId, Integer recipientRole) {
        List<Transaction> allTran = getAllByRecipientIdAndRole(recipientId, recipientRole);
        List<TranVo> allTranVo = new ArrayList<>();

        for (int i = 0; i < allTran.size(); i++) {
            allTranVo.add(fromTranToVo(allTran.get(i)));
        }

        return allTranVo;
    }

    @Override
    public List<TranVo> showAllVoByUserIdAndRole(Integer userId, Integer userRole) {
        List<Transaction> allTran = getAllByPayerIdAndRole(userId, userRole);
        List<TranVo> allTranVo = new ArrayList<>();

        for (int i = 0; i < allTran.size(); i++) {
            allTranVo.add(fromTranToVo(allTran.get(i)));
        }

        allTran = getAllByRecipientIdAndRole(userId, userRole);
        for (int i = 0; i < allTran.size(); i++) {
            allTranVo.add(fromTranToVo(allTran.get(i)));
        }

        return allTranVo;
    }

    @Override
    public TranVo fromTranToVo(Transaction tran) {
        Integer id = tran.getId();
        Timestamp timestamp = tran.getTimestamp();
        String description = tran.getDescription();
        double price = tran.getPrice()/100.00;
        String payer = "";
        String recipient = "";

        if (tran.getPayer_role() == COMPANY)
            payer = companyRepository.findById(tran.getPayer_id()).get().getName();
        else if (tran.getPayer_role() == SELLER)
            payer = sellerRepository.findById(tran.getPayer_id()).get().getUsername();
        else if (tran.getPayer_role() == PLATFORM)
            payer = "借卖平台";

        if (tran.getRecipient_role() == COMPANY)
            recipient = companyRepository.findById(tran.getRecipient_id()).get().getName();
        else if (tran.getRecipient_role() == SELLER)
            recipient = sellerRepository.findById(tran.getRecipient_id()).get().getUsername();
        else if (tran.getRecipient_role() == PLATFORM)
            recipient = "借卖平台";

        return new TranVo(id,timestamp,payer,recipient,description,price);
    }

    @Override
    public void topup(Integer topup_num, Integer userId, Integer userRole) {
        transactionRepository.save(new Transaction(userId, userRole, PLATFORM, 0, "充值", topup_num*100));
    }

    @Override
    public void withdraw(Integer withdraw_num, Integer userId, Integer userRole) {
        transactionRepository.save(new Transaction(0, PLATFORM, userRole, userId, "提现", withdraw_num*100));
    }

}
