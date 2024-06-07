package com.leultewolde.demo3.service;

import com.leultewolde.demo3.dto.BookRequestDto;
import com.leultewolde.demo3.dto.BookResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<List<BookResponseDto>> addAllBooks(List<BookRequestDto> bookRequestDtos);
    Page<BookResponseDto> findAll(int pageNumber, int pageSize, String direction, String sortBy);
}
