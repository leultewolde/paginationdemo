package com.leultewolde.demo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private String title;
    private String isbn;
    private LocalDate publishedDate;
    private BigDecimal price;
}
