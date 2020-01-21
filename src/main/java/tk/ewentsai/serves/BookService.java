package tk.ewentsai.serves;

import com.github.pagehelper.Page;
import tk.ewentsai.model.pojo.Book;

import java.util.ArrayList;

public interface BookService {
    Page<Book> findAllBook();
    Page<Book> findBookByStock();
    ArrayList<Book> findBookByBookName(String bookname);
    Book findBookById(int id);
    Page<Book> sortBySales();
    void updateBook(Book book);
}
