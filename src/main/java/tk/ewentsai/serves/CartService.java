package tk.ewentsai.serves;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.model.entity.Cart;
import tk.ewentsai.model.vo.BookVo;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<Object[]> getCart(int uid);
    Cart getCart(int bookId, int uid);
    void updateAmount(int uid, int bookId, int amount);
    void add(int uid, int bookId);
    void settle(BigDecimal amount, int uid);
    void remove(int uid, int bookId);
    void removeAll(int uid);
}