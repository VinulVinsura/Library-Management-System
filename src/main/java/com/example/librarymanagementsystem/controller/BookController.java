package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.bo.BookBo;
import com.example.librarymanagementsystem.bo.Impl.BookBoImpl;
import com.example.librarymanagementsystem.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    final private BookBo bookBo;

    @PostMapping("/saveBook")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBook(@RequestBody BookDto bookDto){
        boolean isSave = bookBo.saveBook(bookDto);
        if (isSave){
            return "Book Saved";
        }else {
            return "Error";
        }
    }
    @GetMapping("/getBooks")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BookDto> getBook(){
       return bookBo.getBook();
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable  int id){
        if (bookBo.deleteBook(id)){
            return ResponseEntity.ok("Deleted...");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getBookById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookDto searchBook(@PathVariable int id){
        BookDto bookDto = bookBo.searchBook(id);
        if (bookDto!=null) {
            return bookDto;
        }else {
            return null;
        }
    }
}
