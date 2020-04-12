package site.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import site.ewentsai.serves.BookService;
import site.ewentsai.model.dao.BookRepository;
import site.ewentsai.model.entity.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Page<Book> findAll(int page,int num) { return bookRepository.findAll(PageRequest.of(page, num)); }

    @Override
    public List<Book> findAll() { return bookRepository.findAll(); }
    //空库存查询
    @Override
    public Page<Book> findByStockLessThanEqual(int pageNum) { return bookRepository.findByStockLessThanEqual(0, PageRequest.of(pageNum, 10)); }

    @Override
    public Page<Book> search(String bookname) { return bookRepository.findByBooknameContaining(bookname, PageRequest.of(0, 5)); }

    @Override
    public Book search(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Page<Book> orderBySales(int page, int num) { return bookRepository.findAll(PageRequest.of(page, num, Sort.by(Sort.Direction.DESC, "sales"))); }

    @Override
    public boolean update(Book book) {
        bookRepository.save(book);
        return true;
    }
}
