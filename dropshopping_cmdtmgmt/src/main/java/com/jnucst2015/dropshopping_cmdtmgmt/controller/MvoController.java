package com.jnucst2015.dropshopping_cmdtmgmt.controller;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping_cmdtmgmt.service.MvoCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;

@Controller
public class MvoController
{
    @Autowired
    private MvoCommodityService service;

    @GetMapping("/getMvo")
    private String getMvo(Model model)
    {
        model.addAttribute("lsts", service.getAll());
        return "getmvo";
    }

    @GetMapping("/modify")
    private String modifyMvo(Model model, @RequestParam("id") Integer id)
    {
        model.addAttribute("mvo", service.getById(id));
        return "modify";
    }

    @GetMapping("addMvo")
    private String addMvo(Model model)
    {
        model.addAttribute("company_id", 0);
        return "onsale";
    }

    @GetMapping("/detail")
    private String getDetail(Model model, @RequestParam("id") Integer id)
    {
        model.addAttribute("commodity", service.getById(id));
        return "detail";
    }

    @PostMapping("/addMvo")
    private String addOne(
            @RequestParam("class_id") Integer class_id,
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile file,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("state") Integer state,
            @RequestParam("warn_num") Integer warn_num,
            @RequestParam("company_id") Integer company_id,
            @RequestParam("brand_id") Integer brand_id
    )
    {
        String psstPath = "notfound.jpg";
        if (file != null && file.getSize() != 0)
        {
            psstPath = writeFileOrNull(file, psstPath);
        }

        service.add(new MvoCommodity(null, description, psstPath, name, (int) (100 * price), quantity, state, class_id, Timestamp.from(Instant.now()), warn_num, brand_id, company_id));
        return "redirect:/getMvo";
    }

    public String writeFileOrNull(@RequestParam("image") MultipartFile file, String psstPath)
    {
        try
        {
            byte[] bytes = file.getBytes();
            psstPath = System.currentTimeMillis() + "_" + Integer.toHexString(Arrays.hashCode(bytes)) + "." + file.getOriginalFilename().replaceAll("(\\S+)\\.", "");
            Path path = Paths.get("dropshopping_cmdtMgmt/src/main/resources/static/upload/" + psstPath);
            Files.write(path, bytes);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return psstPath;
    }

    @PostMapping("edit")
    private String edit(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "class_id", required = false) Integer class_id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "image", required = false) MultipartFile file,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "state", required = false) Integer state,
            @RequestParam(value = "warn_num", required = false) Integer warn_num,
            @RequestParam(value = "company_id", required = false) Integer company_id,
            @RequestParam(value = "brand_id", required = false) Integer brand_id
    )
    {
        MvoCommodity mvoCommodity = service.getById(id);
        String psstPath = "notfound.jpg";
        if (file != null && file.getSize() != 0)
        {
            psstPath = writeFileOrNull(file, psstPath);
        }
        service.add(
                new MvoCommodity(
                        id,
                        description == null ? mvoCommodity.getDescription() : description,
                        (file == null || file.getSize() == 0) ? mvoCommodity.getImage() : psstPath,
                        name == null ? mvoCommodity.getName() : name,
                        (int) (100 * price),
                        quantity == null ? mvoCommodity.getQuantity() : quantity,
                        state == null ? mvoCommodity.getState() : state,
                        class_id == null ? mvoCommodity.getClass_id() : class_id,
                        Timestamp.from(Instant.now()),
                        warn_num == null ? mvoCommodity.getWarn_num() : warn_num,
                        brand_id == null ? mvoCommodity.getBrand_id() : brand_id,
                        company_id == null ? mvoCommodity.getCompany_id() : company_id
                )
        );
        return "redirect:/getMvo";
    }


}
