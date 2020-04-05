package site.ewentsai.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.ewentsai.model.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    Page<Book> findAll(Pageable pageable);
    List<Book> findAll();
    Page<Book> findByStockLessThanEqual(int stock, Pageable pageable);
    Page<Book> findByBooknameContaining(String bookname, Pageable pageable);
    Book findById(int id);
}
