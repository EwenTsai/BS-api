package tk.ewentsai.serves;

import org.springframework.data.domain.Page;
import tk.ewentsai.model.entity.Book;

import java.util.List;

public interface BookService {
    Page<Book> findAll(int page,int num);
    List<Book> findAll();
    Page<Book> findByStockLessThanEqual(int pageNum);
    Page<Book> search(String bookname);
    Book search(int id);
    Page<Book> orderBySales(int page,int num);
    boolean update(Book book);
}
