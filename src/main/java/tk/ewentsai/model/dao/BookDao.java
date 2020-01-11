package tk.ewentsai.model.dao;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;
import tk.ewentsai.model.pojo.Book;

import java.util.ArrayList;

@Repository
public interface BookDao {
    /**
     * 返回所有书籍
     * 分页显示书籍
     * @return
     */
    Page<Book> findAllBook();

    /**
     * 通过书名查询书
     * @param bookname
     * @return
     */
    ArrayList<Book> findBookByBookName(String bookname);

    /**
     * 通过书本id查询书
     * @param id
     * @return
     */
    Book findBookById(int id);
}
