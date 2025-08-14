package com.t3h.module2.demo.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String title;
    private String author;
    private int pages;
    private String isbn;
    private String summary;
}
