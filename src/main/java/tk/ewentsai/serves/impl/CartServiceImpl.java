package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.CartRepository;
import tk.ewentsai.model.dao.OrdersRepository;
import tk.ewentsai.model.dao.singalOrderRepository;
import tk.ewentsai.model.entity.Cart;
import tk.ewentsai.model.entity.Orders;
import tk.ewentsai.model.entity.singalOrder;
import tk.ewentsai.model.vo.BookVo;
import tk.ewentsai.serves.CartService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private singalOrderRepository singalOrderRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Object[]> getCart(String uid) { return cartRepository.getCart(uid); }

    @Override
    public Cart getCart(int bookId, String uid) {
        return cartRepository.findCartByBookidAndUid(bookId,uid);
    }

    @Override
    public void updateAmount(String uid, int bookId, int amount) { cartRepository.setAmountFor(amount,uid,bookId); }

    @Override
    public void add(String uid, int bookId) {
        Cart cart = cartRepository.findCartByBookidAndUid(bookId,uid);
        //cart不等于null amount=+1 等于null创建
        if(cart==null){
            cart = new Cart(uid,bookId,1);
        }else{
            cart.setAmount(cart.getAmount()+1);
        }
        cartRepository.save(cart);
    }

    @Override
    public void settle(BigDecimal amount, String uid) {
        //生成uuid
        String orderId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        List<BookVo> carts = cartRepository.findCartsByUid(uid);
        ordersRepository.save(new Orders(orderId, uid,carts.size(), amount));

        for(BookVo vo: carts){
            singalOrderRepository.save(new singalOrder(orderId, vo.getId()));
        }

        //结算成功移除购物车商品
        cartRepository.deleteCartsByUid(uid);
    }

    @Override
    public void remove(String uid, int bookId) { cartRepository.deleteCartByBookidAndUid(bookId,uid); }

    @Override
    public void removeAll(String uid) {
        cartRepository.deleteCartsByUid(uid);
    }
}
