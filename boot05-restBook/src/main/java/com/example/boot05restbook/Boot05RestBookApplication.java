package com.example.boot05restbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class Boot05RestBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot05RestBookApplication.class, args);
    }

}
