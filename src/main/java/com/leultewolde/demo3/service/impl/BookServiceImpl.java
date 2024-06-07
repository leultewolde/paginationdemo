package com.leultewolde.demo3.service.impl;

import com.leultewolde.demo3.dto.BookRequestDto;
import com.leultewolde.demo3.dto.BookResponseDto;
import com.leultewolde.demo3.model.Book;
import com.leultewolde.demo3.repository.BookRepository;
import com.leultewolde.demo3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<List<BookResponseDto>> addAllBooks(List<BookRequestDto> bookRequestDtos) {
        // Map List<BookRequestDto> to List<Book>
        List<Book> newBooks = modelMapper.map(bookRequestDtos, new TypeToken<List<Book>>() {
        }.getType());
        // Save all books to db
        List<Book> savedBooks = bookRepository.saveAll(newBooks);
        // Map List<Book> to List<BookResponseDto>
        List<BookResponseDto> savedBooksResponse = modelMapper.map(savedBooks, new TypeToken<List<BookResponseDto>>() {
        }.getType());
        return Optional.of(savedBooksResponse);
    }

    @Override
    public Page<BookResponseDto> findAll(int pageNumber, int pageSize, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(direction), sortBy);
        // returns a page of book entities
        Page<Book> bookPage = bookRepository.findAll(pageable);

        List<BookResponseDto> bookResponseDtoList = bookPage.get()
                .map(book -> modelMapper.map(book, BookResponseDto.class)).toList();

        return new PageImpl<>(bookResponseDtoList, pageable, bookPage.getTotalElements());
    }
}
