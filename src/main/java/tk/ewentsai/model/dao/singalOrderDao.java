package tk.ewentsai.model.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.ewentsai.model.entity.singalOrder;

import java.util.ArrayList;

@Repository
public interface singalOrderDao {
    /**
     * 通过order的id号，查询订单
     * @param orderId
     * @return
     */
    ArrayList<singalOrder> findOrderByOrderId(int orderId);

    /**
     * 通过order的空值，查询订单id号
     * @return
     */
    int findOrderId();

    /**
     * 添加订单
     * @param orderId
     * @param bookId
     */
    void addOrder(@Param("orderId") int orderId, @Param("bookId") int bookId);

    /**
     * 通过订单id号，删除订单
     * @param orderId
     */
    void removeOrderByOrderId(int orderId);
}
