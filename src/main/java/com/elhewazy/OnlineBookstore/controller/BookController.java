package com.elhewazy.OnlineBookstore.controller;

import com.elhewazy.OnlineBookstore.model.Books;
import com.elhewazy.OnlineBookstore.servic.BookServicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {
@Autowired
BookServicImp bd;

@GetMapping("/getAllBooks")
    public List<Books> getallBooks(){
    return  this.bd.getAllBooks();
}
    @GetMapping("/findLessPrice/{price}")
    public List<Books> findLessPrice(@PathVariable double price){
        return  this.bd.findLessPrice(price);
    }
@GetMapping("/getBook/{id}")
public Books getBookById(@PathVariable int id){
    return this.bd.getBook(id);
}
    @GetMapping("/getBookByWriter/{writer}")
    public List<Books> findByWriter(@PathVariable String writer){
        return this.bd.findByWriter(writer);
    }
@PostMapping("/addBook")
    public Books addBook(@RequestBody Books book){
    return this.bd.addBook(book);
}
@PutMapping("/updateBook")
public Books updateBook(@RequestBody Books book){
    return  this.bd.updateBook(book);
}
@DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
    return this.bd.deleteBook(id);
}
}
