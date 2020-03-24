package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import tk.ewentsai.model.entity.singalOrder;

import javax.transaction.Transactional;
import java.util.List;

public interface singalOrderRepository extends JpaRepository<singalOrder,String> {
    List<singalOrder> findByOrderId(int orderId);
    int findByBookIdIsNull();
    @Modifying
    @Transactional
    void deleteByOrderId(String orderId);
}
