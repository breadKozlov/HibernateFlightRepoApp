package by.kozlov.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionManager {

    private static final Configuration configuration = new Configuration();

    public static Session get() {

        configuration.configure();
        return configuration.buildSessionFactory().openSession();
    }
}
