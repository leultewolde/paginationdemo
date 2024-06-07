package com.leultewolde.demo3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String isbn;
    private LocalDate publishedDate;
    private BigDecimal price;

    public Book(String title, String isbn, LocalDate publishedDate, BigDecimal price) {
        this.title = title;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
    }
}
