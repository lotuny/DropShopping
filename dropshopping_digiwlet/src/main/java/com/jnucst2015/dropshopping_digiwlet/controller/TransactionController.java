package com.jnucst2015.dropshopping_digiwlet.controller;

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

    //借卖方电子钱包界面
    @GetMapping("seller_wallet")
    public String sellerWallet(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", sellerService.findById(userId).getBalance()/100.00);
        model.addAttribute("trans", transactionService.showAllVoByUserIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    //借卖方交易记录-支出
    @GetMapping("sellerOnlyPay")
    public String sellerWalletPay(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByPayerIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    //借卖方交易记录-收入
    @GetMapping("sellerOnlyReceive")
    public String sellerWalletRecieve(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        model.addAttribute("balance", sellerService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByRecipientIdAndRole(userId,TransactionServiceImpl.SELLER));
        return "seller_wallet";
    }

    //品牌商电子钱包界面
    @GetMapping("company_wallet")
    public String companyWallet(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", companyService.findById(userId).getBalance()/100.00);
        model.addAttribute("trans", transactionService.showAllVoByUserIdAndRole(userId,TransactionServiceImpl.COMPANY));
        return "company_wallet";
    }

    //品牌商交易记录-支出
    @GetMapping("companyOnlyPay")
    public String companyWalletPay(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("balance", companyService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByPayerIdAndRole(userId,TransactionServiceImpl.COMPANY));
        return "company_wallet";
    }

    //品牌商交易记录-收入
    @GetMapping("companyOnlyReceive")
    public String companyWalletRecieve(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        model.addAttribute("balance", companyService.findById(userId).getBalance());
        model.addAttribute("trans", transactionService.showAllVoByRecipientIdAndRole(userId,TransactionServiceImpl.COMPANY));
        return "company_wallet";
    }

    //品牌商充值操作
    @PostMapping("companyTopup")
    public String company_topup(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        Integer userId =  (Integer) session.getAttribute("userId");
        companyService.topup(num, userId, pay_pwd);
        transactionService.topup(num, userId, TransactionServiceImpl.COMPANY);
        return "redirect:/tran/company_wallet";
    }

    //品牌商提现操作
    @PostMapping("companyWithdraw")
    public String company_withdraw(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        Integer userId =  (Integer) session.getAttribute("userId");
        companyService.topup(num, userId, pay_pwd);
        transactionService.withdraw(num, userId, TransactionServiceImpl.COMPANY);
        return "redirect:/tran/company_wallet";
    }

    //借卖商充值操作
    @PostMapping("sellerTopup")
    public String seller_topup(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        Integer userId =  (Integer) session.getAttribute("userId");
        sellerService.topup(num, userId, pay_pwd);
        transactionService.topup(num, userId, TransactionServiceImpl.SELLER);
        return "redirect:/tran/seller_wallet";
    }

    //借卖商提现操作
    @PostMapping("sellerWithdraw")
    public String seller_withdraw(@RequestParam("num") Integer num,
                               @RequestParam("pay_pwd") String pay_pwd,
                               HttpSession session) {
        Integer userId =  (Integer) session.getAttribute("userId");
        sellerService.withdraw(num, userId, pay_pwd);
        transactionService.withdraw(num, userId, TransactionServiceImpl.SELLER);
        return "redirect:/tran/seller_wallet";
    }

    //添加交易记录
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
