package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMyApp {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
Client client = new Client(2,3,"AdC","Anna","Vaskina","vaslona@gmail","Brandlberger Str.77","01548833");
session.beginTransaction();
session.save(client);
session.getTransaction().commit();
            System.out.println("ok");
            session.close();

        }
    }
}