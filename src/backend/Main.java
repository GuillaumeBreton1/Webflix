package backend;

import backend.hibernate.HibernateUtil;
import façade.LoginFacade;
import gui.Frame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session sessionMain = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        LoginFacade loginFacade = new LoginFacade();
        loginFacade.setCurrentSession(sessionMain);

        Frame rf = new Frame();
        try {
            while (true) {
                transaction = sessionMain.beginTransaction();
                //Pays paysTest = new Pays();
                //paysTest.setNom("canadatest");
                //sessionMain.save(paysTest);
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

