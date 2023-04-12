package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestMyClient {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
Client client = new Client((short) 2, (short) 100,"bcB4","Vera","Vaskina","vaslona@gmail","Brandlberger Str.77","015488332");
session.beginTransaction();
session.save(client);
session.getTransaction().commit();
            System.out.println("ok");
            session.close();
        }
    }
}