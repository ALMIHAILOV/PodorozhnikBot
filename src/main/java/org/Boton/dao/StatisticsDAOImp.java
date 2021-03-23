package org.Boton.dao;

import org.Boton.model.Statistic;
import org.Boton.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class StatisticsDAOImp implements StatisticsDAO{

    @Override
    public void add(Statistic statistic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(statistic);
        tx1.commit();
        session.close();

    }

    @Override
    public String view(long userTelegramId, Date startDate, Date endDate) {
        return null;
    }
}
