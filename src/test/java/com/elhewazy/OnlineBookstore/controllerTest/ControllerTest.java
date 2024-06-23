package com.elhewazy.OnlineBookstore.controllerTest;

import com.elhewazy.OnlineBookstore.controller.BookController;
import com.elhewazy.OnlineBookstore.model.Books;
import com.elhewazy.OnlineBookstore.servic.BookServicImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookServicImp bookServicImp;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void getallBooks() throws Exception {
        List<Books> l = new ArrayList<>();
        when(bookServicImp.getAllBooks()).thenReturn(l);
        mockMvc.perform(get("/getAllBooks")).andExpect(status().isOk());
    }
    @Test
    public void addBooks() throws Exception {
        Books books = new Books("the man","ahmed","2013",3,20.5);
        when(bookServicImp.addBook(books)).thenReturn(books);
        mockMvc.perform(post("/addBook").contentType(MediaType.APPLICATION_JSON
        ).content(objectMapper.writeValueAsString(books))).andExpect(status().isOk());
        //content(objectMapper.writeValueAsString(employeeDto))
    }
    @Test
    public void deletlBooks() throws Exception {
        int id = 1;
        when(bookServicImp.deleteBook(id)).thenReturn("the book deleted");
        ResultActions respons = mockMvc.perform(delete("/deleteBook/{id}",id));
        respons.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void updateBooks() throws Exception {
        Books books = new Books("the man","ahmed","2013",3,20.5);
        when(bookServicImp.updateBook(books)).thenReturn(books);
        mockMvc.perform(put("/updateBook").contentType(MediaType.APPLICATION_JSON
        ).content(objectMapper.writeValueAsString(books))).andExpect(status().isOk());
    }
    @Test
    public void findByWriter() throws Exception {

        List<Books> books = new ArrayList<>();
        Books book = new Books("the man","ahmed","2013",3,20.5);
        books.add(book);
        when(bookServicImp.findByWriter("ahmed")).thenReturn(books);
        ResultActions respons = mockMvc.perform(get("/getBookByWriter/{writer}","ahmed"));
        respons.andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getBookById() throws Exception {
        int id = 1;
        Books books = new Books(1,"the man","ahmed","2013",3,20.5);
        when(bookServicImp.addBook(books)).thenReturn(books);

        mockMvc.perform(get("/getBook/{id}",id).contentType(MediaType.APPLICATION_JSON
        )).andExpect(status().isOk());
        //content(objectMapper.writeValueAsString(employeeDto))
    }

}
