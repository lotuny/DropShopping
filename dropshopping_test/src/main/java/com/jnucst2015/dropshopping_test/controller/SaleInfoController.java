package com.jnucst2015.dropshopping_test.controller;

import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
public class SaleInfoController {

    @Autowired
    private SaleInfoService saleInfoService;

    @PostMapping(value = "/commodity/onsale")
    public String onSale(@RequestParam("mvoCmdtId") Integer mvoCmdtId,
                      @RequestParam("image") MultipartFile image,
                      @RequestParam("name") String name,
                      @RequestParam("description") String description,
                      @RequestParam("price") Integer price,
                      @RequestParam("quantity") Integer quantity,
                      @RequestParam("companyId") Integer companyId,
                      @RequestParam("sellerId") Integer sellerId,
                      @RequestParam("shopId") Integer shopId,
                      @RequestParam("state") Integer state
    ) {
        Path path = Paths.get("blank.jpg");
        try {
            byte[] imageByte = image.getBytes();
            path = Paths.get("src\\main\\resources\\upload\\" + System.currentTimeMillis() + "_" + Integer.toHexString(Arrays.hashCode(imageByte)) + "." + image.getOriginalFilename().replaceAll("(\\S+)\\.",""));
            Files.write(path, imageByte);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        SaleInfo saleInfo = new SaleInfo(mvoCmdtId, shopId, sellerId, name, path.toString(), price, quantity, description, state, companyId);
        saleInfoService.updateSaleInfo(saleInfo);
        return "redirect:/";

    }

    @PostMapping("/saleinfo/update")
    public String update(@RequestParam("name") String name,
                         @RequestParam("description") String description,
                         @RequestParam("price") Integer price,
                         @RequestParam("sellerId") Integer id
    ) {
        saleInfoService.updateSaleInfo(name,description,price,id);
        return "saleinfolist";
    }

    @GetMapping("/saleinfo/list/{sellerId}")
    public String list(@PathVariable("sellerId") Integer sellerId, Model model){
        List<SaleInfo> saleInfoList = saleInfoService.listSaleInfo(sellerId);
        model.addAttribute(saleInfoList);
        return "saleinfolist";
    }

    @GetMapping("/saleinfo/desale/{saleInfoId}")
    public String deSale(@PathVariable("saleInfoId") Integer saleInfoId, HttpSession session){
        saleInfoService.desaleSaleInfo(saleInfoId);
        return "redirect:/saleinfo/list/" + session.getAttribute("userId");
    }

    @GetMapping("/saleinfo/onsaleAgain/{saleInfoId}")
    public String onSaleAgain(@PathVariable("saleInfoId") Integer saleInfoId, HttpSession session){
        saleInfoService.onsaleSaleInfoAgain(saleInfoId);
        return "redirect:/saleinfo/list/" + session.getAttribute("userId");
    }
}
