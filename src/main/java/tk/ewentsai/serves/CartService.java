package tk.ewentsai.serves;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<Cart> getCart(int uid);
    Cart getCart(@Param("bookId") int bookId, @Param("uid") int uid);
    void updateAmount(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);
    void add(@Param("uid") int uid, @Param("bookId") int bookId);
    void settle(@Param("amount")BigDecimal amount, @Param("uid") int uid);
    void remove(@Param("uid") int uid, @Param("bookId") int bookId);
    void removeAll(int uid);
}