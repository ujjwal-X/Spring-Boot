package com.example.boot02dependecyinjection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;
@Component
public class WishMessageGenerator {

    @Autowired(required = true)
    private LocalDateTime date;

    static {
        System.out.println("wish message genrator class file is loading");
    }

    public WishMessageGenerator(){
        System.out.println("WishMessageGenerator 0 param constructor is loading....");
    }

    public String greetUser(String username){
        int hour= date.getHour();
        if(hour<12)
            return "good morning ::"+username;
        else if (hour<16)
            return "good Afternoon ::"+username;
        else if (hour<20)
            return "good evening ::"+username;
        else
            return "good Night ::"+username;

    }

    @Override
    public String toString() {
        return "WishMessageGenerator{" +
                "date=" + date +
                '}';
    }
}
