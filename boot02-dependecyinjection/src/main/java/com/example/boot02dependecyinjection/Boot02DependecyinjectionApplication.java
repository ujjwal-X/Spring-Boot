package com.example.boot02dependecyinjection;

import com.example.boot02dependecyinjection.component.WishMessageGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
//@ComponentScan(basePackages = "component")

public class Boot02DependecyinjectionApplication {
    static{
        System.out.println("com.example.boot02dependecyinjection.Boot02DependecyinjectionApplication .class is loading .....");

    }

    public Boot02DependecyinjectionApplication(){
        System.out.println("com.example.boot02dependecyinjection.Boot02DependecyinjectionApplication 0 param constructor");
    }

    @Bean
    public LocalDateTime createObj(){
        System.out.println("com.example.boot02dependecyinjection.Boot02DependecyinjectionApplication  creating object.....");
        return LocalDateTime.now();
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext=SpringApplication.run(Boot02DependecyinjectionApplication.class, args);

        WishMessageGenerator ws = applicationContext.getBean(WishMessageGenerator.class);

        System.out.println(ws);

        String s=ws.greetUser("Ujjwal");
        System.out.println(s);
    }

}
