package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Select;
import tk.ewentsai.pojo.eBook;

import java.util.ArrayList;

public interface eBookMapper {
    @Select("select * from eBooks")
    ArrayList<eBook> selAll();

    @Select("select * from eBooks limit #{id},10")
    ArrayList<eBook> paginationBook(int id);
}
