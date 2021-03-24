package org.PodorozhnikBot.dao;

import org.PodorozhnikBot.model.Statistic;
import org.PodorozhnikBot.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

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
    public List<Statistic> view(long userTelegramId, Date startDate, Date endDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Statistic> criteriaQuery = builder.createQuery(Statistic.class);
        Root<Statistic> statisticRoot = criteriaQuery.from(Statistic.class);
        criteriaQuery.select(statisticRoot);

        criteriaQuery.where(builder.between(statisticRoot.get("date"), startDate.getTime(), endDate.getTime()),
                            builder.equal(statisticRoot.get("userTelegramId"), userTelegramId));
        List<Statistic> statisticList = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return statisticList;
    }
}
