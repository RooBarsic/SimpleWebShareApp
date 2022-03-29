package com.company.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.company"})
@EnableScheduling
public class ServingWebContentApplication {

    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}