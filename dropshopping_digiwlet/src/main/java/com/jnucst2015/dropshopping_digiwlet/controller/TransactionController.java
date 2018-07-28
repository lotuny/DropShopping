package com.jnucst2015.dropshopping_digiwlet.controller;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping_digiwlet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("mng_transaction")
    public String showAllTran(Model model){
        model.addAttribute("trans", transactionService.getAllTransaction());
        return "mng_transaction";
    }

    @GetMapping("addTran")
    public String addTran() {
        return "addTran";
    }

    @PostMapping("addTran")
    public String addTranImpl(Transaction transaction) {
        transactionService.addTransaction(transaction);
        return "redirect:/mng_transaction";
    }

    @GetMapping("updateTran/{id}")
    public String updateTran(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tran", transactionService.getTransactionByID(id));
        return "updateTran";
    }

    @PostMapping("updateTran")
    public String updateTranImpl(Transaction transaction) {
        transactionService.updateTransaction(transaction);
        return "redirect:/TranIndex";
    }

    @GetMapping("deleteTran/{id}")
    public String deleteTran(@PathVariable("id") Integer id) {
        transactionService.deleteByID(id);
        return "redirect:/TranIndex";
    }
}
