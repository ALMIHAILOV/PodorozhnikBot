package org.Boton.dao;

import org.Boton.model.User;
import org.Boton.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAOImp implements UserDAO{
    @Override
    public boolean findByTelegramId(long userTelegramId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select user_telegram_id from User where user_telegram_id =: userId");
        List<Long> list = query.setParameter("userId", userTelegramId).getResultList();
        session.close();
        return list.isEmpty();
    }

    @Override
    public void add(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void remove(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void topUpBalance(int topUpAmount, long userTelegramId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        int newBalance = currentBalance(userTelegramId) + topUpAmount;
        Query query = session.createQuery("from User where user_telegram_id =:userId");
        query.setParameter("userId", userTelegramId);
        User user = (User) query.getResultList().get(0);
        user.setAvailable_means(newBalance);
        session.update(user);
    }

    @Override
    public int currentBalance(long userTelegramId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where user_telegram_id =: userId");
        User user = (User) query.getSingleResult();
        session.close();
        return user.getAvailable_means();
    }


}
