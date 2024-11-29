package com.example.boot04jpa.dao;

import com.example.boot04jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
public List<User> findByName(String name);
public List<User> findByNameAndCity(String name,String city);


@Query("select u from User u")
List<User> findAllByName();

}
