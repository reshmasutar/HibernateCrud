package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayProductDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        //step-1 Activate hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();//reads the data from cfg file

        //step-2 --> Establish communication link
        factory = cfg.buildSessionFactory();

        //step-3 --> start the session
        ses = factory.openSession();

        //step-4 --> read the data from table
        Product p = ses.load(Product.class, 1);
        System.out.println(p.getProductId());
        System.out.println(p.getProductName());
        System.out.println(p.getProductCategory());
        System.out.println(p.getProductPrice());

    }
}
