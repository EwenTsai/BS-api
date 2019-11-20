package com.ewentsai.dao;

import com.ewentsai.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface CartService {
    ArrayList<Cart> FindCartByUid(int uid);
    Cart FindCartByBookIdAndUid(int bookId, int uid);
    void changeAmountByBookId(@Param("bookId") int bookId, @Param("amount") int amount);
    void removeByBookId(int bookId);
    void addCart(@Param("uid") int uid, @Param("bookId") int bookId, @Param("amount") int amount);
    void removeAll(int uid);
}
