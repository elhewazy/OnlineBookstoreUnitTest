package com.elhewazy.OnlineBookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String writer;
    private String bookYear;
    private int quintity;
    private double price;

    public Books(String name, String writer, String bookYear, int quintity,
   double price) {
        this.name = name;
        this.writer = writer;
        this.bookYear = bookYear;
        this.quintity= quintity;
        this.price = price;
    }
}
