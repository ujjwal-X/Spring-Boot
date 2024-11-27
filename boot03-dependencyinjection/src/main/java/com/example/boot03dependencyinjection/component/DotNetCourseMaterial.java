package com.example.boot03dependencyinjection.component;

import org.springframework.stereotype.Component;

@Component(value = "dot")

public class DotNetCourseMaterial implements Icourse{

    static {
        System.out.println("DotNetCourseMaterial class is loading.....");

    }
    DotNetCourseMaterial(){
        System.out.println("DotNetCourseMaterial 0 args constructor is created");
    }

    @Override
    public String courseContent() {
        return "1. C# oops 2.C# exceptional handling";
    }

    @Override
    public int coursePrice() {
        return 0;
    }
}
