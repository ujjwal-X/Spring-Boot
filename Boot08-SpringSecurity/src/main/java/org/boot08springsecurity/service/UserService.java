package org.boot08springsecurity.service;

import org.boot08springsecurity.dao.UserRepo;
import org.boot08springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User saveUser(User user) throws Exception {
        // Check if the user already exists by ID
        Optional<User> dbUser = userRepo.findById(user.getUser_id());

        // If the user already exists, throw an exception
        if (dbUser.isPresent()) {
            throw new UsernameNotFoundException("User with ID " + user.getUser_id() + " already exists.");
        }


        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(10);

        // Save the new user if not found
        user.setPassword(bcrypt.encode(user.getPassword()));

        System.out.println(user.getPassword());
        return userRepo.save(user);
    }

}
