package com.example.librarymanagementsystem.bo.Impl;

import com.example.librarymanagementsystem.bo.BookBo;
import com.example.librarymanagementsystem.dao.BookDao;
import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.entity.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookBoImpl implements BookBo {

    final BookDao bookDao;  //Dependace injection anothe part (Constructor Injection)
    // BookBoImpl(BookDao bookDao){
    //      this.BookDao=bookDao
    // }

    final ModelMapper modelMapper; // Constructor Injection


    @Override
    public boolean saveBook(BookDto dto) {
       if (bookDao.existsById(dto.getId())){
           return false;
       }else {
          bookDao.save(modelMapper.map(dto, Book.class));
          return true;
       }
    }



    @Override
    public List<BookDto> getBook() {
       List<Book> bookList = bookDao.findAll();
        return modelMapper.map(bookList,new TypeToken<ArrayList<BookDto>>(){}.getType());
    }

    @Override
    public boolean deleteBook(int id) {
        if (bookDao.existsById(id)){
            bookDao.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public BookDto searchBook(int id) {
        if (bookDao.existsById(id)){
            Optional<Book> book = bookDao.findById(id);
            return modelMapper.map(book,BookDto.class);
        }
        return null;
    }

    @Override
    public BookDto searchBookByIsbn(String isbn) {
        Book byIsbn = bookDao.findByIsbn(isbn);
        System.out.println("vinsura");
        return modelMapper.map(byIsbn,BookDto.class);
    }






}


