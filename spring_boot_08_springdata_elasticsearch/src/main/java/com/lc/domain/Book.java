package com.lc.domain;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Description:
 *
 * @Date:2019/6/21
 * @Author:lc
 */
@Document(indexName = "lc", type = "book")
public class Book {

    private Long id;
    private String bookName;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
