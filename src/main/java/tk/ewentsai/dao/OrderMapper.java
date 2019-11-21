package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.ewentsai.pojo.Order;

import java.util.ArrayList;

public interface OrderMapper {
    @Select("select * from singalOrder where orderId = #{orderId}")
    ArrayList<Order> selectOrderByOrderId(int orderId);

    @Select("select orderId from singalOrder where bookId is null")
    int selectOrderId();

    @Insert("insert into singalOrder (id,orderId,bookId) values (default,#{orderId},#{bookId})")
    void insertOrder(@Param("orderId") int orderId, @Param("bookId") int bookId);

    @Delete("delete from singalOrder where orderId = #{orderId}")
    void deleteOrderByOrderId(int orderId);
}
