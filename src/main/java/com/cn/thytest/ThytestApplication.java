package com.cn.thytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThytestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThytestApplication.class, args);
    }

}
