package tk.ewentsai.model.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.ewentsai.model.entity.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Repository
public interface BookDao {
    /**
     * 返回所有书籍
     * 分页显示书籍
     * @return
     */
    Page<Book> findAllBook();

    /**
     * 根据库存查询
     * @return
     */
    Page<Book> findBookByStock();

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

    /**
     * 通过销量排序
     * @return
     */
    Page<Book> selectBookBySales();

    /**
     * 修改书本信息
     * @param id
     * @param bookname
     * @param author
     * @param releaseTime
     * @param intro
     * @param price
     * @param rate
     * @param stock
     * @param sales
     */
    void updateBookById(@Param("id") int id,
                        @Param("bookname") String bookname,
                        @Param("author") String author,
                        @Param("releaseTime") Date releaseTime,
                        @Param("intro") String intro,
                        @Param("price") BigDecimal price,
                        @Param("aboutAuthor")String aboutAuthor,
                        @Param("rate") float rate,
                        @Param("stock") int stock,
                        @Param("sales") int sales);
}
