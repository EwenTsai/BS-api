package tk.ewentsai.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tk.ewentsai.model.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String> {
    List<Cart> findCartsByUid(int uid);
    Cart findCartByBookIdAndUid(int bookId, int uid);

    @Modifying
    @Query("update Cart set amount = ?1 where uid = ?2 and bookId = ?3")
    void setAmountFor(int amount, int uid, int bookId);

    void deleteCartByBookIdAndUid(int bookId, int uid);
    void deleteCartsByUid(int uid);
}
