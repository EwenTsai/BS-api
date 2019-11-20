package com.ewentsai.dao;

import com.ewentsai.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OrderService {
    ArrayList<Order> getOrderByOrderId(int orderId);
    int getOrderId();
    void addOrder(@Param("orderId") int orderId, @Param("bookId") int bookId);
    void removeOrderByOrderId(int orderId);
}
