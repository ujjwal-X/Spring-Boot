package com.example.boot03dependencyinjection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Autowired(required = true)
    @Qualifier("ui")
    Icourse course;

    public void prepration(){
        System.out.println("Student prepration()");
        System.out.println("course choose"+course.courseContent());

        System.out.println("Preparation is going to use "+course.courseContent()+"material with price "+course.coursePrice());
        System.out.println("Preparation is completed "+course.getClass().getSimpleName());
    }



}
