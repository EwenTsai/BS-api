package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ewentsai.model.entity.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,String> {
    List<Orders> findAll();
}
