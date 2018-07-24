package com.jnucst2015.dropshopping_cmdtmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_cmdtmgmt"})
public class DropshoppingCmdtmgmtApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingCmdtmgmtApplication.class, args);
    }

}
