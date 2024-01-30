package com.example.librarymanagementsystem.bo.Impl;

import com.example.librarymanagementsystem.bo.BookBo;
import com.example.librarymanagementsystem.dao.BookDao;
import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.entity.Book;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class BookBoImpl implements BookBo {
    @Autowired
    private BookDao bookDao;
     @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveBook(BookDto dto) {
        if (bookDao.existsById(dto.getId())){
            return false;
        }else {
            bookDao.save(modelMapper.map(dto, Book.class));
            return true;
        }
    }
}
