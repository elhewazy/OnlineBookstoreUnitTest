package com.elhewazy.OnlineBookstore.Dao;


import com.elhewazy.OnlineBookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Books,Integer> {

public List<Books> findByWriter(String writer);
@Query("SELECT u FROM Books u WHERE u.price < ?1")
    public List<Books> findLessPrice(double price);
}
