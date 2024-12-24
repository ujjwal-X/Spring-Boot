package com.socialmedia.controller;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User {

    @Autowired
    private UserService userService;


    @GetMapping("getalluser")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
//        return userService.getAllUser();
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id){
//        return userService.getUser(id);
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @PostMapping("/userfollowcelebrity/{user_id}/{celeb_id}/{platformname}")
    public ResponseEntity<String> followCelebrity (@PathVariable int userid,@PathVariable int celebid,@PathVariable String platform){
        return new ResponseEntity<>(userService.followCeleb(userid,celebid,platform),HttpStatus.OK);
    }


    @PostMapping("adduser")
    public UserDTO setUser(@RequestBody  UserDTO user){
        System.out.println(user);
        return userService.addUser(user);
    }

    @PutMapping("updateuser")
    public UserDTO updateUser(@RequestBody UserDTO user){
        return userService.updatedUser(user);
    }

    @DeleteMapping("deleteuser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
