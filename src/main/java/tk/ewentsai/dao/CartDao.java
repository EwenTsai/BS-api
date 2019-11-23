package tk.ewentsai.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.ewentsai.pojo.Cart;

import java.util.ArrayList;
@Repository
public interface CartDao {

    /**
     * 通过用户的uid，查询对应的购物车
     * @param uid
     * @return
     */
    ArrayList<Cart> findCartByUid(int uid);

    /**
     * 通过书id和用户id，查询对应的书本在购物车的信息
     * @param bookId
     * @param uid
     * @return
     */
    Cart findCartByBookIdAndUid(@Param("bookId") int bookId, @Param("uid") int uid);

    /**
     * 根据用户的id和要书的id，更改购物车中书本的数量
     * @param uid
     * @param bookId
     * @param amount
     */
    void updateAmountByBookIdAndUid(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);

    /**
     * 在购物车中添加对应的书本
     * @param uid
     * @param bookId
     * @param amount
     */
    void addCart(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);

    /**
     * 根据书本id在购物车中删除对应书本
     * @param uid
     * @param bookId
     */
    void removeCartByBookIdAndUid(@Param("uid") int uid, @Param("bookId") int bookId);

    /**
     * 删除制定用户下所有购物车的商品
     * @param uid
     */
    void removeAllByUid(int uid);
}
