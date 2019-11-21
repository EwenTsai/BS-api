package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.pojo.Order;

import java.util.ArrayList;

public interface OrderService {
    ArrayList<Order> getOrderByOrderId(int orderId);
    int getOrderId();
    void addOrder(@Param("orderId") int orderId, @Param("bookId") int bookId);
    void removeOrderByOrderId(int orderId);
}
