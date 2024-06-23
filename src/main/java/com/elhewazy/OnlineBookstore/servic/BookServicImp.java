package com.elhewazy.OnlineBookstore.servic;

import com.elhewazy.OnlineBookstore.Dao.BookDao;
import com.elhewazy.OnlineBookstore.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServicImp implements BookServic{
    @Autowired
    BookDao bd;
    @Override
    public List<Books> getAllBooks() {
        return this.bd.findAll();
    }

    @Override
    public Books getBook(int id) {
        Optional<Books> b = this.bd.findById(id);
Books book = null;
if (b.isPresent()){
book = b.get();
}else{
    throw new RuntimeException("Book Not Found :"+id);
}
        return book;
    }

    @Override
    public Books addBook(Books book) {
        return this.bd.save(book);
    }

    @Override
    public String deleteBook(int id) {

        bd.deleteById(id);

        return "the book deleted";
    }

    @Override
    public Books updateBook(Books book) {
        return this.bd.save(book);
    }

    @Override
    public List<Books> findByWriter(String writer) {
        return this.bd.findByWriter(writer);
    }

    @Override
    public List<Books> findLessPrice(double price) {
        return this.bd.findLessPrice(price);
    }
}
