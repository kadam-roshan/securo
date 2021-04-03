package org.hachiko.service.securo.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {
    static Configuration configuration;

    static {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
    }

    public static SessionFactory getSessionFactory() {
        return configuration.buildSessionFactory();
    }
}
