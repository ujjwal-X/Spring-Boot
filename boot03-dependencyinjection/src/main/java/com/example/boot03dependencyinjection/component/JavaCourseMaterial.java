package com.example.boot03dependencyinjection.component;

import org.springframework.stereotype.Component;

@Component(value = "java")
public class JavaCourseMaterial implements Icourse{
    static {
        System.out.println("JavaCourseMaterial class loading......");
    }
    JavaCourseMaterial(){
        System.out.println("JavaCourseMaterial 0 args constructor");
    }
    @Override
    public String courseContent() {
        return "1. oops 2. exceptional handling 3. collections ";
    }

    @Override
    public int coursePrice() {
        return 4000;
    }
}
