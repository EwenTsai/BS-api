package tk.ewentsai.serves;

import tk.ewentsai.model.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<Object[]> getCart(String uid);
    Cart getCart(int bookId, String uid);
    void updateAmount(String uid, int bookId, int amount);
    void add(String uid, int bookId);
    void settle(BigDecimal amount, String uid);
    void remove(String uid, int bookId);
    void removeAll(String uid);
}