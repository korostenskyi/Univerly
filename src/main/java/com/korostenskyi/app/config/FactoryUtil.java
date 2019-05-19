package com.korostenskyi.app.config;

import com.korostenskyi.app.data.entity.Contract;
import com.korostenskyi.app.data.entity.Department;
import com.korostenskyi.app.data.entity.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public final class FactoryUtil {

    private static Session session;
    private static SessionFactory sessionFactory;

    static {

        Configuration config = new Configuration();
        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.url",  "jdbc:mysql://localhost:3306/university?useSSL=false");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "korostenskyi");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        config.setProperties(properties);

        config.addAnnotatedClass(Department.class);
        config.addAnnotatedClass(Lector.class);
        config.addAnnotatedClass(Contract.class);

        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    private FactoryUtil() {
    }

    public static Session getSession() {
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession() {
        session.close();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
