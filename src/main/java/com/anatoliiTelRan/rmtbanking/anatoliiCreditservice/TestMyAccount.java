package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Account;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;


public class TestMyAccount {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Account account = new Account("BBB3",
                    "vera1", (short) 1, (short) 2, new BigDecimal(10000.00), (short) 21);
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
            System.out.println("ok");
            session.close();
        }
    }
}