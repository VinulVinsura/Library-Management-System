package com.example.librarymanagementsystem.bo;

import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.entity.Book;

import java.util.List;

public interface BookBo {
    boolean saveBook(BookDto dto);

    List<BookDto> getBook();
    boolean deleteBook(int id);
    BookDto searchBook(int id);
    BookDto searchBookByIsbn(String isbn);

}

