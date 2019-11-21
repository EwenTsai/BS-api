package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Select;
import tk.ewentsai.pojo.Book;

import java.util.ArrayList;

public interface BookMapper {
    @Select("select * from books")
    ArrayList<Book> getAllBook();

    @Select("select * from books where id = #{id}")
    Book getBookById(int id);

    @Select("select * from books where bookName like CONCAT(CONCAT('%', #{bookname}), '%')")
    ArrayList<Book> getBookByName(String bookname);

    @Select("select * from books limit #{id},10")
    ArrayList<Book> paginationBook(int id);
}
