package com.example.librarymanagementsystem.bo;

import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.entity.Book;

import java.util.List;

public interface BookBo {
    boolean saveBook(BookDto dto);
    Book getByIsbn(String isbn);
    List<BookDto> getBook();

}

