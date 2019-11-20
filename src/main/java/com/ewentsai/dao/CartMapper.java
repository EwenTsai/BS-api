package com.ewentsai.dao;

import com.ewentsai.pojo.Cart;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface CartMapper {
    @Select("select * from cart where uid = #{uid}")
    ArrayList<Cart> getCartByUid(int uid);

    @Select("select * from cart where bookId = #{bookId} and uid = #{uid}")
    Cart getCartByBookIdAndUid(@Param("bookId") int bookId, @Param("uid") int uid);

    @Update("update cart set amount = #{amount} where bookId = #{bookId}")
    void updateCartByBookId(@Param("bookId") int bookId, @Param("amount") int amount);

    @Delete("delete from cart where bookId = #{bookId}")
    void deleteCartByBookId(int bookId);

    @Insert("insert into cart (id,uid,bookId,amount) values (default,#{uid},#{bookId},#{amount})")
    void insertCart(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);

    @Delete("delete from cart where uid = #{uid}")
    void deleteAll(int uid);
}
