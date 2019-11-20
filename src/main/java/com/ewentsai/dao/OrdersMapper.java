package com.ewentsai.dao;

import com.ewentsai.pojo.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface OrdersMapper {
    @Select("select * from orders")
    ArrayList<Orders> selectAll();

    @Select("select * from orders where uid = #{uid}")
    ArrayList<Orders> selectOrdersByUid(int uid);

    @Select("select * from orders where id = #{orderId}")
    Orders selectOrdersByOrderId(int orderId);

    @Select("select * from orders limit #{id},10")
    ArrayList<Orders> paginationOrders(int id);

    @Insert("insert into orders (id,uid,number,amount,createTime) values (default,#{uid},#{number},#{amount},now())")
    void insertOrder(@Param("uid") int uid, @Param("number") int number, @Param("amount") BigDecimal amount);

    @Delete("delete from orders where id = #{id}")
    void deleteOrderById(int id);
}
