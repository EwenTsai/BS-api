package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.pojo.Cart;

import java.util.ArrayList;

public interface CartService {
    ArrayList<Cart> findCartByUid(int uid);
    Cart findCartByBookIdAndUid(@Param("bookId") int bookId, @Param("uid") int uid);
    void updateAmountByBookIdAndUid(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);
    void addCart(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);
    void removeCartByBookIdAndUid(@Param("uid") int uid, @Param("bookId") int bookId);
    void removeAllByUid(int uid);
}