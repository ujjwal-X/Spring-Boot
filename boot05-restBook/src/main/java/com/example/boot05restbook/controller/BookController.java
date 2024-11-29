package com.example.boot05restbook.controller;
import com.example.boot05restbook.entity.Book;
import com.example.boot05restbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService service;
    @GetMapping(value = "/books")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list=service.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
    }



    @GetMapping(value = "/books/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id")int id){
      Optional<Book> book=service.getBookById(id);
      if(book==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      else {
          return ResponseEntity.of(Optional.of(book));
      }
    }


    @PostMapping(value = "/books")
    public ResponseEntity<List<Book>>  addBook(@RequestBody List<Book> b){

        try {
           service.addBook(b);
            return ResponseEntity.of(Optional.of(b));
        }
        catch (Exception e){
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping(value = "/books/{id}")

    public ResponseEntity<Void>  getBook(@PathVariable(value = "id") int bid){
       try{
           service.deleteBook(bid);
           return ResponseEntity.ok().build();
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }


    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") int id,@RequestBody Book book) {
        try {
            service.updatedList(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
