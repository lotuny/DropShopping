package com.jnucst2015.dropshopping_mvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_mvo"})
public class DropshoppingMvoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingMvoApplication.class, args);
    }
}
