package tk.ewentsai.dao;

import org.springframework.stereotype.Repository;
import tk.ewentsai.pojo.Book;

import java.util.ArrayList;

@Repository
public interface BookDao {
    /**
     * 返回所有书籍
     * @return
     */
    ArrayList<Book> findAllBook();

    /**
     * 通过书名查询书
     * @param bookname
     * @return
     */
    ArrayList<Book> findBookByBookName(String bookname);

    /**
     * 分页显示书籍
     * @param id
     * @return
     */
    ArrayList<Book> paginationBook(int id);

    /**
     * 通过书本id查询书
     * @param id
     * @return
     */
    Book findBookById(int id);
}
