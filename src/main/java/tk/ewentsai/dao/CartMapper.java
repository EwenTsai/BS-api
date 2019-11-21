package tk.ewentsai.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;
import tk.ewentsai.pojo.Cart;

import java.util.ArrayList;

public interface CartMapper {
    @Select("select * from cart where uid = #{uid}")
    ArrayList<Cart> getCartByUid(int uid);

    @Select("select * from cart where bookId = #{bookId} and uid = #{uid}")
    Cart getCartByBookIdAndUid(@Param("bookId") int bookId, @Param("uid") int uid);

    "update cart set amount = #{amount} where bookId = #{bookId} and uid = #{uid}"
    void updateCartByBookId(@Param("bookId") int bookId, @Param("amount") int amount);

    @Delete("delete from cart where bookId = #{bookId} and uid = #{uid}")
    void deleteCartByBookId(int bookId);

    @Insert("insert into cart (id,uid,bookId,amount) values (default,#{uid},#{bookId},#{amount})")
    void insertCart(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);

    @Delete("delete from cart where uid = #{uid}")
    void deleteAll(int uid);
}
