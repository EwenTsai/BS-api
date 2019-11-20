package com.ewentsai.dao;

import com.ewentsai.pojo.Cart;

import java.util.ArrayList;

public class CartServiceImpl implements CartService {
    private CartMapper cartMapper;

    public CartMapper getCartMapper() { return cartMapper; }
    public void setCartMapper(CartMapper cartMapper) { this.cartMapper = cartMapper; }

    @Override
    public ArrayList<Cart> FindCartByUid(int uid) { return cartMapper.getCartByUid(uid); }

    @Override
    public Cart FindCartByBookIdAndUid(int bookId,int uid) { return cartMapper.getCartByBookIdAndUid(bookId,uid); }

    @Override
    public void changeAmountByBookId(int bookId, int amount) { cartMapper.updateCartByBookId(bookId,amount); }

    @Override
    public void removeByBookId(int bookId) { cartMapper.deleteCartByBookId(bookId); }

    @Override
    public void addCart(int uid, int bookId, int amount) { cartMapper.insertCart(uid,bookId,amount); }

    @Override
    public void removeAll(int uid) { cartMapper.deleteAll(uid); }
}
