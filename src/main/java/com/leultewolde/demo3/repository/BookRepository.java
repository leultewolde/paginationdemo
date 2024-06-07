package com.leultewolde.demo3.repository;

import com.leultewolde.demo3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
