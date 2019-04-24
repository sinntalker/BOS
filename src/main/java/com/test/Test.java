package com.test;

import com.example.Demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Demo demo = new Demo();
        demo.setId(2);
        demo.setUsername("bob");
        demo.setPassword("123456");
        demo.setEmail("bob@163.com");
        session.save(demo);
        transaction.commit();
        session.close();
        System.out.println("Successful saved.");
    }
}
