package com.elhewazy.OnlineBookstore.serviceTest;

import com.elhewazy.OnlineBookstore.Dao.BookDao;
import com.elhewazy.OnlineBookstore.model.Books;
import com.elhewazy.OnlineBookstore.servic.BookServicImp;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServicTest {
    @Mock
    private BookDao bookDao;

    @InjectMocks
    BookServicImp bookServicImp;

    @Test
    public void getAllBooks(){

        bookServicImp.getAllBooks();
        verify(bookDao).findAll();
    }
    @Test
    public void getBook(){
        int id = 1;
        Books book2 = new Books(1,"the man","ahmed","2013",3,20.5);
        Optional<Books> b = Optional.of(book2);
        when(bookDao.findById(id)).thenReturn(b);
        bookServicImp.getBook(1);
        verify(bookDao).findById(id);
    };
    @Test
    public void addBook(){
        Books book1 = new Books("the man","ahmed","2013",3,20.5);
        Books book2 = new Books(1,"the man","ahmed","2013",3,20.5);
        when(bookDao.save(book1)).thenReturn(book2);
        bookServicImp.addBook(book1);
        verify(bookDao).save(book1);
    };
    @Test
    public void deleteBook(){

        int id =1;

        bookServicImp.deleteBook(id);
        verify(bookDao).deleteById(id);
    };
    @Test
    public void updateBook(){
        Books book1 = new Books("the man","ahmed","2013",3,20.5);
        when(bookDao.save(book1)).thenReturn(book1);
        bookServicImp.updateBook(book1);
        verify(bookDao).save(book1);
    };
    @Test
    public void findByWriter(){
        Books book1 = new Books(2,"the woman","mohamed","2013",4,22.5);
        Books book2 = new Books(1,"the man","ahmed","2014",3,20.5);
         String writer = "ahmed";
       List<Books> l = new ArrayList<>();
       l.add(book1);
       l.add(book2);
        when(bookDao.findByWriter(writer)).thenReturn(l);
        bookServicImp.findByWriter(writer);
        verify(bookDao).findByWriter(writer);
    };
    @Test
    public void findLessPrice(){
        Books book1 = new Books(2,"the woman","mohamed","2013",4,22.5);
        Books book2 = new Books(1,"the man","ahmed","2014",3,20.5);
        double price = 30.0;
        List<Books> l = new ArrayList<>();
        l.add(book1);
        l.add(book2);
        when(bookDao.findLessPrice(price)).thenReturn(l);
        bookServicImp.findLessPrice(price);
        verify(bookDao).findLessPrice(price);
    };
}
