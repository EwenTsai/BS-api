package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ewentsai.model.entity.singalOrder;

import java.util.List;

public interface singalOrderRepository extends JpaRepository<singalOrder,String> {
    List<singalOrder> findByOrderId(int orderId);
    int findByBookIdIsNull();
    void deleteByOrderId(int orderId);
}
