package com.example.boot03dependencyinjection.component;

import org.springframework.stereotype.Component;

@Component(value = "ui")
public class UiCourseMaterial implements Icourse {
    static {
        System.out.println("UiCourseMaterial class is loading.....");

    }
    UiCourseMaterial(){
        System.out.println("UiCourseMaterial 0 args constructor is created");
    }

    @Override
    public String courseContent() {
        return "1- Figma 2-Canvas CSS 3-HTML";
    }

    @Override
    public int coursePrice() {
        return 2000;
    }
}
