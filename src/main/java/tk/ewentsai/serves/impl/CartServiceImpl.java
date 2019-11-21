package tk.ewentsai.serves.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ewentsai.dao.CartDao;
import tk.ewentsai.pojo.Cart;
import tk.ewentsai.serves.CartService;

import java.util.ArrayList;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public ArrayList<Cart> findCartByUid(int uid) {
        return cartDao.findCartByUid(uid);
    }

    @Override
    public Cart findCartByBookIdAndUid(int bookId, int uid) {
        return cartDao.findCartByBookIdAndUid(bookId,uid);
    }

    @Override
    public void updateCartByBookId(int uid, int bookId, int amount) {
        cartDao.updateCartByBookId(uid,bookId,amount);
    }

    @Override
    public void addCart(int uid, int bookId, int amount) {
        cartDao.addCart(uid,bookId,amount);
    }

    @Override
    public void removeCartByBookId(int uid, int bookId) {
        cartDao.removeCartByBookId(uid,bookId);
    }

    @Override
    public void removeAll(int uid) {
        cartDao.removeAll(uid);
    }
}
