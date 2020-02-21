package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.singalOrderDao;
import tk.ewentsai.model.entity.singalOrder;
import tk.ewentsai.serves.singalOrderService;

import java.util.ArrayList;
@Service
public class singalOrderServiceImpl implements singalOrderService {
    @Autowired
    private singalOrderDao singalOrderDao;
    @Override
    public ArrayList<singalOrder> findOrderByOrderId(int orderId) {
        return singalOrderDao.findOrderByOrderId(orderId);
    }

    @Override
    public int findOrderId() {
        return singalOrderDao.findOrderId();
    }

    @Override
    public void addOrder(int orderId, int bookId) {
        singalOrderDao.addOrder(orderId,bookId);
    }

    @Override
    public void removeOrderByOrderId(int orderId) {
        singalOrderDao.removeOrderByOrderId(orderId);
    }
}
