package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.entity.singalOrder;

import java.util.ArrayList;

public interface singalOrderService {
    ArrayList<singalOrder> findOrderByOrderId(int orderId);
    int findOrderId();
    void addOrder(@Param("orderId") int orderId, @Param("bookId") int bookId);
    void removeOrderByOrderId(int orderId);
}
