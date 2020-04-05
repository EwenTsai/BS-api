package site.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.ewentsai.serves.singalOrderService;
import site.ewentsai.model.dao.singalOrderRepository;
import site.ewentsai.model.entity.singalOrder;

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
    public void addOrder(String orderId, int bookId) { singalOrderRepository.save(new singalOrder(orderId, bookId)); }

    @Override
    public void removeOrderByOrderId(String orderId) { singalOrderRepository.deleteByOrderId(orderId); }
}
