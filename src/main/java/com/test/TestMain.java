package com.test;

import com.example.Demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestMain {

    Configuration configuration = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction transaction = null;

    @Before
    public void init() {
        System.out.println("init start");
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        System.out.println("init end");
    }

    @Test
    public void insert() {
        System.out.println("insert start");
        try {
            Demo demo = new Demo();
            demo.setId(4);
            demo.setUsername("Sinn");
            demo.setPassword("123456");
            demo.setEmail("Sinn@163.com");
            session.save(demo);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("insert end");
    }

    @Test
    public void update() {
        System.out.println("update start");
        Demo demo = (Demo) session.get(Demo.class, new Integer(2));
        demo.setUsername("pennyLi");
        session.update(demo);
        transaction.commit();
        session.close();
        System.out.println("update end");
    }

    @Test
    public void getById() {
        System.out.println("getById start");
        Demo demo = (Demo) session.get(Demo.class, new Integer(3));
        transaction.commit();
        session.close();
        System.out.println("用户ID： " + demo.getId()
                + ", 用户名称：" + demo.getUsername()
                + ", 用户密码：" + demo.getPassword()
                + "用户邮箱： " + demo.getEmail());
        System.out.println("getById end");
    }

    @Test
    public void delete() {
        System.out.println("delete start");
        try {
            Demo demo = (Demo) session.get(Demo.class, new Integer(1));
            session.delete(demo);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("delete end");
    }

}
