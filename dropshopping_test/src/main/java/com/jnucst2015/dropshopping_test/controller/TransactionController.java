package com.jnucst2015.dropshopping_test.controller;

import com.jnucst2015.dropshopping.entity.Transaction;
import com.jnucst2015.dropshopping_test.service.CompanyService;
import com.jnucst2015.dropshopping_test.service.SellerService;
import com.jnucst2015.dropshopping_test.service.TransactionService;
import com.jnucst2015.dropshopping_test.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("tran")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("mng")
    public String tranMng(Model model) {
        model.addAttribute("trans", transactionService.showAllTranVo());
        return "mng_transaction";
    }

    //获取借卖方电子钱包界面
    @GetMapping("seller_wallet")
    public String sellerWallet(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByUserIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    @GetMapping("seller_wallet/onlyPay")
    public String sellerWalletPay(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByPayerIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    @GetMapping("seller_wallet/onlyReceive")
    public String sellerWalletRecieve(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByRecipientIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    //获取品牌商电子钱包界面
    @GetMapping("company_wallet")
    public String companyWallet(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", companyService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByUserIdAndRole(userId,TransactionServiceImpl.COMPANY));
        return "company_wallet";
    }

    @GetMapping("company_wallet/onlyPay")
    public String companyWalletPay(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", companyService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByPayerIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "company_wallet";
    }

    @GetMapping("company_wallet/onlyReceive")
    public String companyWalletRecieve(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        model.addAttribute("balance", companyService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByRecipientIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "company_wallet";
    }

    //借卖商充值操作
    @PostMapping("seller_wallet/topup")
    public String seller_topup(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        sellerService.topup(num, (Integer) session.getAttribute("userId"), pay_pwd);
        return "redirect:/tran/seller_wallet";
    }

    @PostMapping("seller_wallet/withdraw")
    public String seller_withdraw(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        sellerService.withdraw(num, (Integer) session.getAttribute("userId"), pay_pwd);
        return "redirect:/tran/seller_wallet";
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
