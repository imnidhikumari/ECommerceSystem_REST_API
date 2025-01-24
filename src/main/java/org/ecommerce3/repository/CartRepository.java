package org.ecommerce3.repository;

import org.ecommerce3.entity.Cart;
import org.ecommerce3.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

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

    public Optional<Cart> getAllCartByUserId(String userId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createNamedQuery("getAllCartByUserId", Cart.class);
            query.setParameter("userId", userId);
            return Optional.ofNullable(query.uniqueResult());
        }
    }
}
