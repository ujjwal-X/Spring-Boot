package com.example.boot03dependencyinjection;

import com.example.boot03dependencyinjection.component.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Boot03DependencyinjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(Boot03DependencyinjectionApplication.class, args);
        Student s=context.getBean(Student.class);
        System.out.println(s);

        s.prepration();

    }

}
