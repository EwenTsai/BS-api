package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.BookDao;
import tk.ewentsai.model.pojo.Book;
import tk.ewentsai.serves.BookService;

import java.util.ArrayList;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public ArrayList<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public ArrayList<Book> findBookByBookName(String bookname) {
        return bookDao.findBookByBookName(bookname);
    }

    @Override
    public ArrayList<Book> paginationBook(int id) {
        return bookDao.paginationBook(id);
    }

    @Override
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }
}
