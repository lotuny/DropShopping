package com.jnucst2015.dropshopping_digiwlet.controller;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping_digiwlet.service.CompanyService;
import com.jnucst2015.dropshopping_digiwlet.service.SellerService;
import com.jnucst2015.dropshopping_digiwlet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("wallet")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CompanyService companyService;

    //获取借卖方电子钱包界面
    @GetMapping("seller_wallet")
    public String sellerWallet(HttpSession session) {
        //return "seller_wallet/"+session.getAttribute("userId");
        return "redirect:/seller_wallet/1";
    }

    @GetMapping("seller_wallet/{userId}")
    public String sellerWallet(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        return "seller_wallet";
    }

    //获取品牌商电子钱包界面
    @GetMapping("company_wallet")
    public String companyWallet(HttpSession session) {
        return "company_wallet/"+session.getAttribute("userId");
    }

    @GetMapping("company_wallet/{userId}")
    public String companyWallet(@PathVariable("userId") Integer userId,  Model model) {
        model.addAttribute("balance", companyService.findById(userId));
        return "company_wallet";
    }

    //借卖商充值操作
    @PostMapping("seller_wallet/topup")
    public String seller_topup(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        sellerService.topup(num, (Integer) session.getAttribute("userId"), pay_pwd);
        return "redirect:/seller_wallet";
    }

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
