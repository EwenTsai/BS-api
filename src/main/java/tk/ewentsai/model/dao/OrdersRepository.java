package tk.ewentsai.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tk.ewentsai.model.entity.Orders;

import javax.transaction.Transactional;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,String> {

    List<Orders> findAll();
    Page<Orders> findOrdersByUid(String uid, Pageable pageable);
    Orders findOrdersById(int id);
    //获取订单详情信息SQL
    @Query(nativeQuery = true,
            value = "select books.bookname " +
                    "from orders, singal_order, books " +
                    "where orders.id = singal_order.order_id = ?1 " +
                    "and books.id = singal_order.book_id")
    List<Object> getOrderDetailBookname(int orderId);
    @Modifying
    @Transactional
    void deleteById(int id);

}
