package com.jnucst2015.dropshopping_oderMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_oderMgmt"})
@EnableEurekaClient
public class DropshoppingOrderApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingOrderApplication.class, args);
    }
}
