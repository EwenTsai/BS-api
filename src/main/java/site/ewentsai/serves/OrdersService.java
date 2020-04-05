package site.ewentsai.serves;

import org.springframework.data.domain.Page;
import site.ewentsai.model.entity.Orders;
import site.ewentsai.model.vo.OrderDetailVo;

import java.util.List;

public interface OrdersService {
    List<Orders> returnAll();
    Page<Orders> getOrders(int uid, int pageNum);
    Orders getOrder(String orderId);
    OrderDetailVo getOrderDetail(String orderId);
//    void add(String uid, int number, BigDecimal amount);
    void remove(String id);
}
