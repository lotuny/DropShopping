package com.jnucst2015.dropshopping_digiwlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_digiwlet"})
public class DropshoppingDigiwletApplication {

    public static void main(String[] args) {
        SpringApplication.run(DropshoppingDigiwletApplication.class, args);
    }
}
