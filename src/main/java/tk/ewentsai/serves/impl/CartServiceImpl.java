package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.model.dao.CartRepository;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.model.entity.Cart;
import tk.ewentsai.model.vo.BookVo;
import tk.ewentsai.serves.CartService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Object[]> getCart(int uid) { return cartRepository.a(uid); }

    @Override
    public Cart getCart(int bookId, int uid) {
        return cartRepository.findCartByBookIdAndUid(bookId,uid);
    }

    @Override
    public void updateAmount(int uid, int bookId, int amount) { cartRepository.setAmountFor(amount,uid,bookId); }

    @Override
    public void add(int uid, int bookId) {
        Cart cart = cartRepository.findCartByBookIdAndUid(bookId,uid);
        cart.setAmount(cart.getAmount()+1);
        cartRepository.save(cart);
    }

    @Override
    public void settle(BigDecimal amount, int uid) {
//        List<BookVo> carts = cartRepository.findCartsByUid(uid);
//        int number = 0;
//        for(Cart cart : carts){
//            number+=cart.getAmount();
//        }
        //转至orderRepository
//        ordersDao.addOrder(uid,number,amount);
//        //通过空值来获得orderid
//        int orderId = singalOrderDao.findOrderId();
//        singalOrderDao.removeOrderByOrderId(orderId);
//
//        for(Cart cart : carts){
//            singalOrderDao.addOrder(orderId,cart.getBookId());
//        }

        //结算成功移除购物车商品
        cartRepository.deleteCartsByUid(uid);
    }

    @Override
    public void remove(int uid, int bookId) { cartRepository.deleteByBookIdAndUid(bookId,uid); }

    @Override
    public void removeAll(int uid) {
        cartRepository.deleteCartsByUid(uid);
    }
}
