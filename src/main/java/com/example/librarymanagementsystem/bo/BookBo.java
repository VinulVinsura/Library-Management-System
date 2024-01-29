package com.example.librarymanagementsystem.bo;

import com.example.librarymanagementsystem.dto.BookDto;

public interface BookBo {
    boolean saveBook(BookDto dto);
}
