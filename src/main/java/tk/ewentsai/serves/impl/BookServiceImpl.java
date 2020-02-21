package tk.ewentsai.serves.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.BookDao;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.serves.BookService;

import java.util.ArrayList;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Page<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public Page<Book> findBookByStock() { return bookDao.findBookByStock(); }

    @Override
    public ArrayList<Book> findBookByBookName(String bookname) {
        return bookDao.findBookByBookName(bookname);
    }


    @Override
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }

    @Override
    public Page<Book> sortBySales() { return bookDao.selectBookBySales(); }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBookById(
                book.getId(),
                book.getBookname(),
                book.getAuthor(),
                book.getReleaseTime(),
                book.getIntro(),
                book.getPrice(),
                book.getAboutAuthor(),
                book.getRate(),
                book.getStock(),
                book.getSales());
    }
}
