package com.basalt.basalttransactionmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BasaltTransactionModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasaltTransactionModuleApplication.class, args);
    }

}
