package tk.ewentsai.serves;

import org.springframework.data.domain.Page;
import tk.ewentsai.model.entity.Orders;
import tk.ewentsai.model.vo.OrderDetailVo;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersService {
    List<Orders> returnAll();
    Page<Orders> getOrders(String uid, int pageNum);
    Orders getOrder(int orderId);
    OrderDetailVo getOrderDetail(int orderId);
    void add(String uid, int number, BigDecimal amount);
    void remove(int id);
}
