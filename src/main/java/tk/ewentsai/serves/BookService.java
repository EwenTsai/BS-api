package tk.ewentsai.serves;

import org.springframework.data.domain.Page;
import tk.ewentsai.model.entity.Book;

import java.util.List;

public interface BookService {
    Page<Book> findAll(int page);
    Page<Book> findByStockLessThanEqual(int pageNum);
    Page<Book> findBookByBooknameIsLike(String bookname);
    Book findBookById(int id);
    Page<Book> findAllOrderBySales(int pageNum);
    boolean update(Book book);
}
