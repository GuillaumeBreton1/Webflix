package backend;

import backend.hibernate.HibernateUtil;
import façade.Facade;
import gui.Frame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session sessionMain = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Facade facade = new Facade();
        facade.setCurrentSession(sessionMain);

        Frame rf = new Frame();
        
        try {

            while (true) {
                //Pays paysTest = new Pays();
                //paysTest.setNom("canadatest");
                //sessionMain.save(paysTest);
                transaction = sessionMain.beginTransaction();
                transaction.commit();

            }


        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            sessionMain.close();
        }
    }

}

