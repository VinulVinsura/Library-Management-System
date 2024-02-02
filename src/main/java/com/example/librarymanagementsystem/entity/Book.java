package com.example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="Book")

public class Book {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int qty;
}
