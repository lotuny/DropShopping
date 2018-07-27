package com.jnucst2015.dropshopping_cmdtmgmt.controller;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping.service.MvoCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
public class MvoRestController
{
    @Autowired private MvoCommodityService service;

    @GetMapping
    private List<MvoCommodity> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/recent?count={count}")
    private List<MvoCommodity> getRecent(@PathVariable("count") Integer count)
    {
        return service.getRecent(count);
    }

    @GetMapping("/get?id={id}")
    private MvoCommodity getOne(@PathVariable Integer id)
    {
        return service.getById(id);
    }

    @PostMapping("/addMvo")
    private MvoCommodity addOne(
            @RequestParam("class_id") Integer class_id,
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile file,
            @RequestParam("description") String description,
            @RequestParam("price") Integer price,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("state") Integer state,
            @RequestParam("warn_num") Integer warn_num,
            @RequestParam("company_id") Integer company_id,
            @RequestParam("brand_id") Integer brand_id
    )
    {
        String psstPath = "notfound.jpg";
        try
        {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
            Files.write(path, bytes);
            psstPath = file.getOriginalFilename();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return service.add(new MvoCommodity(null, description, psstPath, name, price, quantity, state, class_id, Timestamp.from(Instant.now()), warn_num, brand_id, company_id));
    }

    @PostMapping("/delete")
    private void delete(@RequestParam("id") Integer id)
    {
        service.deleteById(id);
    }

    @PostMapping("/deleteInBatch")
    private void delete(@RequestParam("commodities") String commodities)
    {
        service.deleteByIds(commodities);
    }

    @PostMapping("/edit")
    private MvoCommodity edit(@RequestParam("commodity") MvoCommodity mvoCommodity)
    {
        return service.update(mvoCommodity);
    }


}
