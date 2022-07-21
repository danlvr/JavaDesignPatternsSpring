package com.example.javadesignpatternsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JavaDesignPatternsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDesignPatternsSpringApplication.class, args);
    }

}
