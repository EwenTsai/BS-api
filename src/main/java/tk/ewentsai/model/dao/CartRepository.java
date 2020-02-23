package tk.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ewentsai.model.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String> {
    List<Cart> findCartsByUid(int uid);
    Cart findCartByBookIdAndUid(int bookId, int uid);
    void deleteCartByBookIdAndUid(int bookId, int uid);
    void deleteCartsByUid(int uid);
}
