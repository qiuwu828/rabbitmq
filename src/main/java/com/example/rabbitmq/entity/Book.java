package com.example.rabbitmq.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 丘戊
 * @package com.mybatis.springbootmybatis.entity
 * @title
 * @date 12/4/2022 下午 4:51
 */
public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubTime;
    private String author;
    private Integer typeId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

//    构造方法

    public Book() {
    }

    public Book(Integer bookId, String bookName, double price, Date pubTime, String author, Integer typeId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.pubTime = pubTime;
        this.author = author;
        this.typeId = typeId;
    }
}
