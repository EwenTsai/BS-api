package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.BookRepository;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.serves.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(int page,int num) { return bookRepository.findAll(PageRequest.of(page, num)); }
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
    public Page<Book> orderBySales(int pageNum) { return bookRepository.findAll(PageRequest.of(pageNum, 10, Sort.by(Sort.Direction.DESC, "sales"))); }

    @Override
    public boolean update(Book book) {
        bookRepository.save(book);
        return true;
    }
}
