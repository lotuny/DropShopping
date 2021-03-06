package com.jnucst2015.dropshopping_oderMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_oderMgmt"})

public class DropshoppingOrderApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingOrderApplication.class, args);
    }
}
