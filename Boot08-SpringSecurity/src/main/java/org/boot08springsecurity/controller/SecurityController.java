package org.boot08springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/home")
    public String greet(HttpServletRequest request){
        return "Hello Spring Securtiy"+request.getSession();
    }
    @GetMapping(value = "/about")
    public String  aboutUs(HttpServletRequest request){
        return "About us"+request.getSession()+"id"+request.getSession().getId();
    }

}
