package com.jnucst2015.dropshopping_forwarder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DropshoppingForwarderApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingForwarderApplication.class, args);
    }
}
