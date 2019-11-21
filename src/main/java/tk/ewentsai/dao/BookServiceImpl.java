package tk.ewentsai.dao;

import tk.ewentsai.pojo.Book;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {
    private BookMapper BookMapper;

    public BookMapper getBookMapper() { return BookMapper; }
    public void setBookMapper(BookMapper bookMapper) { BookMapper = bookMapper; }

    public ArrayList<Book> selAll() {
        return BookMapper.getAllBook();
    }

    public Book FindById(int id) {
        return BookMapper.getBookById(id);
    }

    public ArrayList<Book> FindByName(String bookname) {
        return BookMapper.getBookByName(bookname);
    }

    @Override
    public ArrayList<Book> paginationBook(int id) { return BookMapper.paginationBook(id); }
}
