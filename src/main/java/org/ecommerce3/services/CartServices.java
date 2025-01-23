package org.ecommerce3.services;

import org.ecommerce3.entity.Cart;
import org.ecommerce3.repository.CartRepository;

public class CartServices {
    private final CartRepository cartRepository;

    public CartServices(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addCart(Cart cart) {
        return cartRepository.addCart(cart);
    }
}
