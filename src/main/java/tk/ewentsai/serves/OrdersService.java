package tk.ewentsai.serves;

import org.springframework.data.domain.Page;
import tk.ewentsai.model.entity.Orders;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersService {
    List<Orders> returnAll();
    Page<Orders> getOrders(int uid, int pageNum);
    Orders getOrder(int orderId);
    List<Object> getOrderDetail(int orderId);
    void add(int uid, int number, BigDecimal amount);
    void remove(int id);
}
