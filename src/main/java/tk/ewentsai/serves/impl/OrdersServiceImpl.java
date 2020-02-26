package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.OrdersRepository;
import tk.ewentsai.model.entity.Orders;
import tk.ewentsai.serves.OrdersService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository OrdersRepository;

    @Override
    public List<Orders> returnAll() {
        return OrdersRepository.findAll();
    }

    @Override
    public Page<Orders> getOrders(int uid, int pageNum) { return OrdersRepository.findOrdersByUid(uid, PageRequest.of(pageNum, 10)); }

    @Override
    public Orders getOrder(int orderId) { return OrdersRepository.findOrdersById(orderId); }

    @Override
    public List<Object> getOrderDetail(int orderId) {
        List<Object> orderDetail = OrdersRepository.getOrderDetail(orderId);
        for(Object o : orderDetail ){

        }
        return null;
    }

    @Override
    public void add(int uid, int number, BigDecimal amount) { OrdersRepository.save(new Orders(uid, number, amount)); }

    @Override
    public void remove(int id) { OrdersRepository.deleteById(id); }
}
