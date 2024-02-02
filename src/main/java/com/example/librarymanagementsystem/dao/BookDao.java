package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface BookDao extends JpaRepository<Book,Integer> {

    Book getBookByIsbn(String isbn);
}
