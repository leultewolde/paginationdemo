package com.leultewolde.demo3.controller;

import com.leultewolde.demo3.dto.BookRequestDto;
import com.leultewolde.demo3.dto.BookResponseDto;
import com.leultewolde.demo3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize,
            @RequestParam String direction,
            @RequestParam String sortBy
    ) {
        Page<BookResponseDto> bookResponseDtoPage = bookService.findAll(pageNo, pageSize, direction, sortBy);
        if (bookResponseDtoPage.getTotalElements() > 0) {
            return ResponseEntity.ok(bookResponseDtoPage.getContent());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Optional<List<BookResponseDto>>> createBooks(
            @RequestBody List<BookRequestDto> bookRequestDtos
    ) throws URISyntaxException {
        Optional<List<BookResponseDto>> bookResponseDtos = bookService.addAllBooks(bookRequestDtos);
        if (bookResponseDtos.isPresent()) {
            return ResponseEntity.created(new URI("/books")).body(bookResponseDtos);
        }
        return ResponseEntity.noContent().build();
    }

}
