package com.example.boot05restbook.repository;

import com.example.boot05restbook.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
