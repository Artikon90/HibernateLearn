package org.artikon90;

import org.artikon90.model.Item;
import org.artikon90.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 4);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println(items);
            session.getTransaction().commit();
            System.out.println(person.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
