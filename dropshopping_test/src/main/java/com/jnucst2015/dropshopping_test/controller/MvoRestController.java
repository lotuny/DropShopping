package com.jnucst2015.dropshopping_test.controller;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping_test.service.MvoCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MvoRestController
{
    @Autowired private MvoCommodityService service;

    //lotuny edified
    @GetMapping("/mvo")
    private List<MvoCommodity> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/recent")
    private List<MvoCommodity> getRecent(@RequestParam("count") Integer count)
    {
        return service.getRecent(count);
    }

    @GetMapping("/get")
    private MvoCommodity getOne(@RequestParam("id") Integer id)
    {
        return service.getById(id);
    }

    @PostMapping("/up")
    private void up(@RequestParam("id") Integer id)
    {
        service.up(id);
    }

    @PostMapping("/down")
    private void down(@RequestParam("id") Integer id)
    {
        service.down(id);
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


}
