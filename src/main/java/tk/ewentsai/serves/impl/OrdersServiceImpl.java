package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.OrdersDao;
import tk.ewentsai.model.pojo.Orders;
import tk.ewentsai.serves.OrdersService;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public ArrayList<Orders> returnAll() {
        return ordersDao.returnAll();
    }

    @Override
    public ArrayList<Orders> getOrders(int uid) {
        return ordersDao.findOrdersByUid(uid);
    }

    @Override
    public Orders getOrder(int orderId) {
        return ordersDao.findOrdersByOrderId(orderId);
    }

    @Override
    public void add(int uid, int number, BigDecimal amount) {
        ordersDao.addOrder(uid,number,amount);
    }

    @Override
    public void remove(int id) {
        ordersDao.removeOrderById(id);
    }
}
