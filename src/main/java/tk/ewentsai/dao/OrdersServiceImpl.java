package tk.ewentsai.dao;

import tk.ewentsai.pojo.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrdersServiceImpl implements OrdersService{

    private OrdersMapper ordersMapper;

    public OrdersMapper getOrdersMapper() { return ordersMapper; }
    public void setOrdersMapper(OrdersMapper ordersMapper) { this.ordersMapper = ordersMapper; }

    @Override
    public ArrayList<Orders> getAllOrders() { return ordersMapper.selectAll(); }

    @Override
    public ArrayList<Orders> getOrdersByUid(int uid) { return ordersMapper.selectOrdersByUid(uid); }

    @Override
    public Orders getOrdersByOrderId(int orderId) { return ordersMapper.selectOrdersByOrderId(orderId); }

    @Override
    public ArrayList<Orders> paginationOrders(int id) { return ordersMapper.paginationOrders(id); }

    @Override
    public void addOrders(int uid, int number, BigDecimal amount) { ordersMapper.insertOrder(uid,number,amount); }

    @Override
    public void removeOrdersByOrderId(int id) { ordersMapper.deleteOrderById(id); }
}
