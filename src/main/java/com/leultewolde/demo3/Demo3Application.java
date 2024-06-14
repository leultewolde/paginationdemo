package com.leultewolde.demo3;

import com.leultewolde.demo3.dto.BookRequestDto;
import com.leultewolde.demo3.dto.BookResponseDto;
import com.leultewolde.demo3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Demo3Application {

//    private final BookService bookService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<BookRequestDto> bookRequestDtos = List.of(
//          new BookRequestDto("book 1", "123456789", LocalDate.now(), BigDecimal.valueOf(10)),
//          new BookRequestDto("book 2", "987654321", LocalDate.now(), BigDecimal.valueOf(20)),
//          new BookRequestDto("book 3", "345678901", LocalDate.now(), BigDecimal.valueOf(30)),
//          new BookRequestDto("book 4", "567890123", LocalDate.now(), BigDecimal.valueOf(40))
//        );
//
//        Optional<List<BookResponseDto>> bookResponseDtos = bookService.addAllBooks(bookRequestDtos);
//        bookResponseDtos.ifPresent(res -> {
//            System.out.println(
//                    res.stream().map(BookResponseDto::toString).collect(Collectors.joining(",\n"))
//            );
//        });
//        Page<BookResponseDto> page;
//        int pageNumber = 0;
//        int pageSize = 2;
//        do {
//            page = bookService.findAll(pageNumber++, pageSize, Sort.Direction.DESC.toString(), "title");
//            System.out.println("--Book Page "+pageNumber+" --");
//            System.out.println(page.get().map(BookResponseDto::toString).collect(Collectors.joining(",\n")));
//        } while (page.hasNext());
//    }

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

}
