package tk.ewentsai.dao;

import tk.ewentsai.pojo.singalOrder;

import java.util.ArrayList;

public class OrderServiceImpl implements OrderService{

    private OrderMapper orderMapper;

    public OrderMapper getOrderMapper() { return orderMapper; }
    public void setOrderMapper(OrderMapper orderMapper) { this.orderMapper = orderMapper; }

    @Override
    public ArrayList<singalOrder> getOrderByOrderId(int orderId) { return orderMapper.selectOrderByOrderId(orderId); }

    @Override
    public int getOrderId() { return orderMapper.selectOrderId(); }

    @Override
    public void addOrder(int orderId, int bookId) { orderMapper.insertOrder(orderId,bookId); }

    @Override
    public void removeOrderByOrderId(int orderId) { orderMapper.deleteOrderByOrderId(orderId); }
}
