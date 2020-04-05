package site.ewentsai.serves;

import site.ewentsai.model.entity.singalOrder;

import java.util.List;

public interface singalOrderService {
    List<singalOrder> findOrderByOrderId(int orderId);
//    int findOrderId();
    void addOrder(String orderId, int bookId);
    void removeOrderByOrderId(String orderId);
}
