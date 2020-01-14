package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.pojo.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface OrdersService {
    ArrayList<Orders> returnAll();
    ArrayList<Orders> getOrders(int uid);
    Orders getOrder(int orderId);
    void add(@Param("uid") int uid, @Param("number") int number, @Param("amount") BigDecimal amount);
    void remove(int id);
}
