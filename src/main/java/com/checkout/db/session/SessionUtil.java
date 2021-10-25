package com.checkout.db.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class SessionUtil {

    private static final SessionUtil INSTANCE = new SessionUtil();
    private final SessionFactory sessionFactory;

    public static SessionUtil getInstance() {
        return INSTANCE;
    }

    public SessionUtil() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return getInstance().sessionFactory.openSession();
    }
}
