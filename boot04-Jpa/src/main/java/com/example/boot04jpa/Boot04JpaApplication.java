package com.example.boot04jpa;

import com.example.boot04jpa.dao.UserRepo;
import com.example.boot04jpa.entity.User;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.stream.*;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Boot04JpaApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Boot04JpaApplication.class, args);
        UserRepo user=context.getBean(UserRepo.class);


//        User u1=new User();
//        u1.setName("shubham");
//        u1.setCity("indore");
//        u1.setStatus("React Devloper");
//
//
//
//        User u2=new User();
//        u2.setName("Ishant Saxena");
//        u2.setCity("indore");
//        u2.setStatus("Flutter Devloper");
//
//
//        User u3=new User();
//        u3.setName("Karan");
//        u3.setCity("indore");
//        u3.setStatus("JavaScript Devloper");



//        user.save(u3); //saving single  user
//
//        List<User> l= Arrays.asList(u1,u2,u3);
//
//        user.saveAll(l);


//        update
// found


//        it takes out only singe data   how to get the data
//        Optional<User> findOne=user.findById(4);
//        User  found= findOne.get();
//        System.out.println(found);


//        Find all to fetch all the data from database
//        Iterable<User> findAll=user.findAll();
//        findAll.forEach(user1 -> System.out.println(user1));

//        delete
//        Optional<User> findOne=user.findById(4);
//        User  found= findOne.get();
//        user.delete(found);
//         delete specific fields from database
//        user.deleteById(3);

//        delete all filed from data base
//        user.deleteAll();
//        System.out.println("deleted");



//  Lesson 2 ->      Custom Finder methods
//        https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
//        List<User> searchByName=user.findByName("ishant saxena");
//        searchByName.forEach(user1 -> System.out.println(user1));



//        Lessson 3 => @Query using custom Query

//        List<User> nameAndCity=user.findByNameAndCity("Karan","indore");
//        System.out.println(nameAndCity);


        List<User> getAllByName=user.findAllByName();
        System.out.println(getAllByName);




    }

}
