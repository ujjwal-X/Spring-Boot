package com.example.boot01basicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //internally use @ComponentScan @Configuration @EnableAutoconfiguration
public class Boot01BasicappApplication {

    public static void main(String[] args) {
        System.out.println("First Spring program");

       ApplicationContext context= SpringApplication.run(Boot01BasicappApplication.class, args);
        System.out.println(context.getClass().getName());
    }

}
