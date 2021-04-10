package com.shumile.druid_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TranDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TranDemoApplication.class, args);
    }



}
