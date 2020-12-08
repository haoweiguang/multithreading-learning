package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("hi light");
        SpringApplication.run(SpringDemoApplication.class, args);
        throw new Exception("e");

    }

}
