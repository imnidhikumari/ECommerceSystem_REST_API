package org.ecommerce3.repository;

import org.ecommerce3.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UsersRepository {
    private final SessionFactory sessionFactory;

    public UsersRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Users registerUser(Users user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            return user;
        }
    }

    public List<Users> findAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createNamedQuery("getAllUsers", Users.class);
            return query.list();
        }
    }

    public void deleteUser(Users user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    public Users findUserByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createNamedQuery("findUserByEmail", Users.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }
}
