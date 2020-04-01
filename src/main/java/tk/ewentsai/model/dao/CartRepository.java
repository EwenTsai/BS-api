package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tk.ewentsai.model.entity.Cart;
import tk.ewentsai.model.vo.BookVo;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String> {

//    购物车详情获取
    @Query(nativeQuery = true,
            value = "select books.id,books.bookname, books.price, cart.amount " +
                    "from books, cart " +
                    "where cart.uid = ?1 and cart.bookid = books.id")
    List<Object[]> getCart(int uid);
    Cart findCartByBookidAndUid(int bookid, int uid);
    //modifying 注解标示update sql
    @Modifying
    @Query("update Cart set amount = ?1 where uid = ?2 and bookid = ?3")
    void setAmountFor(int amount, int uid, int book_id);

    List<Cart> findCartsByUid(int uid);

    //使用spring data jpa 的删除操作，需要加注解@Modifying     @Transactional
    // 否则报错如下： No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
    @Modifying
    @Transactional
    void deleteCartByBookidAndUid(int bookid, int uid);
    @Modifying
    @Transactional
    void deleteCartsByUid(int uid);
}
