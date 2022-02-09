package ru.gb.spring.app.product.dao.cart;


import ru.gb.spring.app.product.entity.Cart;

public interface CartDao {
    Cart save(Cart cart);
}
