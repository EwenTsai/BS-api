package tk.ewentsai.model.dao;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;
import tk.ewentsai.model.entity.eBook;

@Repository
public interface eBookDao {
    /**
     * 从数据库中查询搜索书籍
     * @return
     */
    Page<eBook> selAll();
}
