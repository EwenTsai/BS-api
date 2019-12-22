package tk.ewentsai.model.dao;

import org.springframework.stereotype.Repository;
import tk.ewentsai.model.pojo.eBook;

import java.util.ArrayList;

@Repository
public interface eBookDao {
    /**
     * 从数据库中查询搜索书籍
     * @return
     */
    ArrayList<eBook> selAll();

    /**
     * 分页显示
     * @param id
     * @return
     */
    ArrayList<eBook> paginationBook(int id);
}
