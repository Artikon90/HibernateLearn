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
        session.beginTransaction();
        Person person = session.get(Person.class, 1);
        System.out.println(person.getAge());
        System.out.println(person.getName());
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
