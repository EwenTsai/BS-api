package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.ewentsai.pojo.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface OrdersDao {
    /**
     * 返回所有order订单
     * @return
     */
    ArrayList<Orders> returnAll();

    /**
     * 通过order的uid号，查询订单
     * @param uid
     * @return
     */
    ArrayList<Orders> findOrdersByUid(int uid);

    /**
     * 通过order的id号，查询订单
     * @param orderId
     * @return
     */
    Orders findOrdersByOrderId(int orderId);

    /**
     * 分页显示
     * @param id
     * @return
     */
    ArrayList<Orders> paginationOrders(int id);

    /**
     * 添加订单
     * @param uid
     * @param number
     * @param amount
     */
    void addOrder(@Param("uid") int uid, @Param("number") int number, @Param("amount") BigDecimal amount);

    /**
     * 通过订单id号，删除订单
     * @param id
     */
    void removeOrderById(int id);
}
