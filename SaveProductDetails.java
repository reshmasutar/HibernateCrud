package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails {
    public static void main(String[] arg) {
        //declare objects
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step-1 --> Activate hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();//reads the data from cfg file

        //step-2 --> Establish Communicetion link
        factory = cfg.buildSessionFactory();

        //step-3 --> start the session
        ses = factory.openSession();

        //step-4 --> create object of domain class
        Product p1 = new Product();
        p1.setProductId(1);
        p1.setProductName("LAPTOP");
        p1.setProductCategory("ELECTRONICS");
        p1.setProductPrice(45000.50);

        //step-5 --> start the transaction
        tx = ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY");

    }
}
