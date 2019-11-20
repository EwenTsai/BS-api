package com.ewentsai.dao;

import com.ewentsai.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface OrdersService {
    ArrayList<Orders> getAllOrders();
    ArrayList<Orders> getOrdersByUid(int uid);
    Orders getOrdersByOrderId(int orderId);
    ArrayList<Orders> paginationOrders(int id);
    void addOrders(@Param("uid") int uid, @Param("number") int number, @Param("amount") BigDecimal amount);
    void removeOrdersByOrderId(int id);
}
