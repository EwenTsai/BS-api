package tk.ewentsai.serves.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.CartDao;
import tk.ewentsai.model.dao.OrdersDao;
import tk.ewentsai.model.dao.singalOrderDao;
import tk.ewentsai.model.entity.Cart;
import tk.ewentsai.serves.CartService;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private singalOrderDao singalOrderDao;

    @Override
    public Page<Cart> getCart(int uid) { return cartDao.findCartByUid(uid); }

    @Override
    public Cart getCart(int bookId, int uid) {
        return cartDao.findCartByBookIdAndUid(bookId,uid);
    }

    @Override
    public void updateAmount(int uid, int bookId, int amount) { cartDao.updateAmountByBookIdAndUid(uid,bookId,amount); }

    @Override
    public void add(int uid, int bookId) {
        Cart cart = cartDao.findCartByBookIdAndUid(bookId,uid);
        if(cart==null){
            cartDao.addCart(uid,bookId,1);
        }else{
            updateAmount(uid,bookId,cart.getAmount()+1);
        }
    }

    @Override
    public void settle(BigDecimal amount, int uid) {
        Page<Cart> carts = cartDao.findCartByUid(uid);
        int number = 0;
        for(Cart cart : carts){
            number+=cart.getAmount();
        }
        ordersDao.addOrder(uid,number,amount);
        //通过空值来获得orderid
        int orderId = singalOrderDao.findOrderId();
        singalOrderDao.removeOrderByOrderId(orderId);

        for(Cart cart : carts){
            singalOrderDao.addOrder(orderId,cart.getBookId());
        }

        //结算成功移除购物车商品
        cartDao.removeAllByUid(uid);
    }

    @Override
    public void remove(int uid, int bookId) { cartDao.removeCartByBookIdAndUid(uid,bookId); }

    @Override
    public void removeAll(int uid) {
        cartDao.removeAllByUid(uid);
    }
}
