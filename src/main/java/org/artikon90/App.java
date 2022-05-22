package org.artikon90;

import org.artikon90.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person("Random Name", 45);
            session.persist(person);
            session.getTransaction().commit();
            System.out.println(person.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
