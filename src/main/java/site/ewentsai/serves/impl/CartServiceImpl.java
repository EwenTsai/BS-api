package site.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.ewentsai.model.dao.CartRepository;
import site.ewentsai.model.dao.OrdersRepository;
import site.ewentsai.model.dao.singalOrderRepository;
import site.ewentsai.model.entity.Cart;
import site.ewentsai.model.entity.Orders;
import site.ewentsai.model.entity.singalOrder;
import site.ewentsai.serves.CartService;

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
    public List<Object[]> getCart(int uid) { return cartRepository.getCart(uid); }

    @Override
    public Cart getCart(int bookId, int uid) {
        return cartRepository.findCartByBookidAndUid(bookId,uid);
    }

    @Override
    public void updateAmount(int uid, int bookId, int amount) { cartRepository.setAmountFor(amount,uid,bookId); }

    @Override
    public void add(int uid, int bookId) {
        Cart cart = cartRepository.findCartByBookidAndUid(bookId,uid);
        //cart不等于null amount=+1 等于null创建
        if(cart==null){
            cart = new Cart(uid,bookId);
        }else{
            cart.setAmount(cart.getAmount()+1);
        }
        cartRepository.save(cart);
    }

    @Override
    public void settle(BigDecimal amount, int uid) {
        //生成uuid
        String orderId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        List<Cart> carts = cartRepository.findCartsByUid(uid);
        ordersRepository.save(new Orders(orderId, uid,carts.size(), amount));

        for(Cart cart: carts){
            singalOrderRepository.save(new singalOrder(orderId, cart.getBookid()));
        }

        //结算成功移除购物车商品
        cartRepository.deleteCartsByUid(uid);
    }

    @Override
    public void remove(int uid, int bookId) { cartRepository.deleteCartByBookidAndUid(bookId,uid); }

    @Override
    public void removeAll(int uid) {
        cartRepository.deleteCartsByUid(uid);
    }
}
