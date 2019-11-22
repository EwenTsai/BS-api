package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.dao.OrdersDao;
import tk.ewentsai.pojo.Orders;
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
    public ArrayList<Orders> findOrdersByUid(int uid) {
        return ordersDao.findOrdersByUid(uid);
    }

    @Override
    public Orders findOrdersByOrderId(int orderId) {
        return ordersDao.findOrdersByOrderId(orderId);
    }

    @Override
    public ArrayList<Orders> paginationOrders(int id) {
        return ordersDao.paginationOrders(id);
    }

    @Override
    public void addOrder(int uid, int number, BigDecimal amount) {
        ordersDao.addOrder(uid,number,amount);
    }

    @Override
    public void removeOrderById(int id) {
        ordersDao.removeOrderById(id);
    }
}
