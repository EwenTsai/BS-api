package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tk.ewentsai.model.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String> {

    void deleteByBookIdAndUid(int bookId, int uid);
    void deleteCartsByUid(int uid);

//    购物车详情获取
    @Query(nativeQuery = true,
            value = "select books.id,books.bookname, books.price, cart.amount " +
                    "from books, cart " +
                    "where cart.uid = ?1 and cart.bookid = books.id")
    List<Object[]> a(int uid);
    Cart findCartByBookIdAndUid(int bookId, int uid);
    //modifying 注解标示update sql
    @Modifying
    @Query("update Cart set amount = ?1 where uid = ?2 and bookId = ?3")
    void setAmountFor(int amount, int uid, int bookId);
}
