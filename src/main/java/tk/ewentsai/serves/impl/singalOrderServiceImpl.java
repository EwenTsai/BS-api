package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.singalOrderRepository;
import tk.ewentsai.model.entity.singalOrder;
import tk.ewentsai.serves.singalOrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class singalOrderServiceImpl implements singalOrderService {

    @Autowired
    private singalOrderRepository singalOrderRepository;

    @Override
    public List<singalOrder> findOrderByOrderId(int orderId) { return singalOrderRepository.findByOrderId(orderId); }

//    @Override
//    public int findOrderId() {
//        return singalOrderRepository.findOrderId();
//    }

    @Override
    public void addOrder(int orderId, int bookId) { singalOrderRepository.save(new singalOrder(orderId, bookId)); }

    @Override
    public void removeOrderByOrderId(int orderId) { singalOrderRepository.deleteByOrderId(orderId); }
}
