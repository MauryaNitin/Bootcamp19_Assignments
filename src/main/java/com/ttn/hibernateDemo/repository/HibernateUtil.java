package com.ttn.hibernateDemo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final static SessionFactory sessionFactory;
    private static Session session ;

    static {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    private HibernateUtil(){}

    public static Session getSession(){
        if(session == null){
            synchronized (HibernateUtil.class){
                if(session == null){
                    session = sessionFactory.openSession();
                }
            }
        }
        return session;
    }

    public static void shutdown(){
        session.close();
        sessionFactory.close();
    }
}
