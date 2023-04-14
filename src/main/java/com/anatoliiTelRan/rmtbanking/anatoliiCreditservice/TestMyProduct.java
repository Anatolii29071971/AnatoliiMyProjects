package com.anatoliiTelRan.rmtbanking.anatoliiCreditservice;

import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Account;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Manager;
import com.anatoliiTelRan.rmtbanking.anatoliiCreditservice.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

public class TestMyProduct {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Product product = new Product((short) 1,"Eksklusiv", (short) 2,3, new BigDecimal(1000.0000),  new BigDecimal(1000.00));
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            System.out.println("ok");
            session.close();
        }
    }
}
