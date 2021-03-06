package site.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import site.ewentsai.model.dao.OrdersRepository;
import site.ewentsai.model.entity.Orders;
import site.ewentsai.model.vo.OrderDetailVo;
import site.ewentsai.serves.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository OrdersRepository;

    @Autowired
    private site.ewentsai.serves.singalOrderService singalOrderService;

    @Override
    public List<Orders> returnAll() {
        return OrdersRepository.findAll();
    }

    @Override
    public Page<Orders> getOrders(int uid, int pageNum) { return OrdersRepository.findOrdersByUid(uid, PageRequest.of(pageNum, 10)); }

    @Override
    public Orders getOrder(String orderId) { return OrdersRepository.findOrdersById(orderId); }

    @Override
    public OrderDetailVo getOrderDetail(String orderId) {
        Orders order = OrdersRepository.findOrdersById(orderId);
        List<Object> orderDetail = OrdersRepository.getOrderDetailBookname(orderId);
        String[] booknames = new String[orderDetail.size()];
        for(int i = 0; i<orderDetail.size(); i++){
            booknames[i] = (String)orderDetail.get(i);
        }
        return new OrderDetailVo(orderId, order.getAmount(), booknames);
    }

//    @Override
//    public void add(String uid, int number, BigDecimal amount) { OrdersRepository.save(new Orders(uid, number, amount)); }

    @Override
    public void remove(String id) {
        OrdersRepository.deleteById(id);
        singalOrderService.removeOrderByOrderId(id);
    }
}
