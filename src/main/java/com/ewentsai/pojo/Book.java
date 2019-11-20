package com.ewentsai.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Book {
        private int id;
        private String bookname;
        private String author;
        private Date releaseTime;
        private String intro;
        private float price;
        private float rate;
        private String aboutAuthor;
}
