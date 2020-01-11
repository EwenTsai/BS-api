package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.pojo.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface OrdersService {
    ArrayList<Orders> returnAll();
    ArrayList<Orders> findOrdersByUid(int uid);
    Orders findOrdersByOrderId(int orderId);
    void addOrder(@Param("uid") int uid, @Param("number") int number, @Param("amount") BigDecimal amount);
    void removeOrderById(int id);
}
