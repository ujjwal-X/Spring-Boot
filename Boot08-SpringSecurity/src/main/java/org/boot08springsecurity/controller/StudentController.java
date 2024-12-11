package org.boot08springsecurity.controller;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletRequest;
import org.boot08springsecurity.entity.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students=new ArrayList<>(List.of(new Student(1,"Shubham","ReactJS"),
            new Student(2,"Ishant","Flutter"),
            new Student(3,"Karan","HTML,CSS,JS"),
            new Student(4,"Vishal","Java")));



    @GetMapping(value = "students")
    List<Student> getAllStudents(){
        return students;
    }

    @GetMapping(value = "csrf-token")
    CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping(value = "students")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "data is successfully added";
    }
}
