package com.elhewazy.OnlineBookstore.servic;

import com.elhewazy.OnlineBookstore.model.Books;

import java.util.List;

public interface BookServic {

    public List<Books> getAllBooks();
    public Books getBook(int id);
    public Books addBook(Books book);
    public String deleteBook(int id);
    public Books updateBook(Books book);
    public List<Books> findByWriter(String writer);
    public List<Books> findLessPrice(double price);
}
