package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilFaz {
    private static final SessionFactory sessionFactory = buildSessionFactoryFaz();

    private static SessionFactory buildSessionFactoryFaz() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Échec de la création de la SessionFactory : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void arreterFaz() {
        getSessionFactory().close();
        System.out.println("SessionFactory fermée avec succès.");
    }
}
