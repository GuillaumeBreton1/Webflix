package backend;

import backend.hibernate.HibernateUtil;
import backend.hibernate.tableMapping.Pays;
import org.hibernate.*;

public class Main {
    public static void main(String[] args) {
        Session sessionMain = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = sessionMain.beginTransaction();
            Pays paysTest = new Pays();
            paysTest.setNom("canadatest");
            sessionMain.save(paysTest);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            sessionMain.close();
        }
    }

}
