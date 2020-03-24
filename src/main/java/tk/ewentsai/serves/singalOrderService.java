package tk.ewentsai.serves;

import tk.ewentsai.model.entity.singalOrder;

import java.util.List;

public interface singalOrderService {
    List<singalOrder> findOrderByOrderId(int orderId);
//    int findOrderId();
    void addOrder(String orderId, int bookId);
    void removeOrderByOrderId(String orderId);
}
