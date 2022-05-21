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
            Person person1 = new Person("Sasha", 35);
            Person person2 = new Person("Alex", 23);
            Person person3 = new Person("Vlad", 25);
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
