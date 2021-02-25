package backend.courtier;

import antlr.PrintWriterWithSMAP;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

public class CourtierLocation {

    public int locationExemplaire(Integer idClient, Integer idFilm, Session session) throws Exception{

        try {

            Query query = session.createSQLQuery(" { call p_louerExemplaire(?,?) }");
            query.setInteger(0, idClient);
            query.setInteger(1, idFilm);
            query.executeUpdate();
        } catch (HibernateException e) {
            StringWriter sw  = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            System.out.println("e: " + sw.toString());
            if(sw.toString().contains("limite")){
                return 1;

            }else if(sw.toString().contains("Aucun exemplaire")){
                return 2;
            }

        }

        return 0;
    }


}
