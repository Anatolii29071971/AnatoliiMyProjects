package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMyManager {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Manager manager = new Manager("Ivan","Petrov", (short) 2,"Nummer 1");
            session.beginTransaction();
            session.save(manager);
            session.getTransaction().commit();
            System.out.println("ok");
            session.close();
        }
    }
}
