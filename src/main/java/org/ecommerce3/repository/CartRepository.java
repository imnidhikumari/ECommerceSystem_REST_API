package org.ecommerce3.repository;

import org.ecommerce3.entity.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CartRepository {
    private final SessionFactory sessionFactory;

    public CartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Cart addCart(Cart cart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cart);
            session.getTransaction().commit();
            return cart;
        }
    }
}
