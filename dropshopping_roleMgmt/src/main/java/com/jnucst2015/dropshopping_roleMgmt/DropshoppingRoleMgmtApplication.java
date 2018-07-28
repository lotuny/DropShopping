package com.jnucst2015.dropshopping_roleMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_roleMgmt"})
public class DropshoppingRoleMgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DropshoppingRoleMgmtApplication.class, args);
    }
}
