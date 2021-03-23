package org.PodorozhnikBot.utils;

import org.PodorozhnikBot.model.Statistic;
import org.PodorozhnikBot.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {


        if (sessionFactory == null) {
            try {
                Map<String,String> jdbcUrlSettings = new HashMap<>();
                String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
                if (null != jdbcDbUrl) {
                    jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
                }

                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Statistic.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        configure("hibernate.cfg.xml").
                        applySettings(jdbcUrlSettings);
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
