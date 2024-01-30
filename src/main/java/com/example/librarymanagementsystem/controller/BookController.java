package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.bo.BookBo;
import com.example.librarymanagementsystem.bo.Impl.BookBoImpl;
import com.example.librarymanagementsystem.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")

public class BookController {
    @Autowired
    private BookBo bookBo;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody BookDto bookDto){
        boolean isSave = bookBo.saveBook(bookDto);
        if (isSave){
            return "Book Saved";
        }else {
            return "Error";
        }
    }
}
