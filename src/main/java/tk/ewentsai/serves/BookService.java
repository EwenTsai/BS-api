package tk.ewentsai.serves;

import tk.ewentsai.model.pojo.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAllBook();
    ArrayList<Book> findBookByBookName(String bookname);
    ArrayList<Book> paginationBook(int id);
    Book findBookById(int id);
}
