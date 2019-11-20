package com.ewentsai.dao;


import com.ewentsai.pojo.Book;

import java.util.ArrayList;

interface BookService {
    ArrayList<Book> selAll();
    Book FindById(int id);
    ArrayList<Book> FindByName(String bookname);
    ArrayList<Book> paginationBook(int id);
}
