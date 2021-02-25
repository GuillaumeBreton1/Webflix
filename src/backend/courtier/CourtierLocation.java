package backend.courtier;

import org.hibernate.Query;
import org.hibernate.Session;

public class CourtierLocation {

    public boolean locationExemplaire(Integer idClient, Integer idFilm, Session session) {
        boolean locationValide = true;

        try {

            Query query = session.createSQLQuery(" { call p_louerExemplaire(?,?) }");
            query.setInteger(0, idClient);
            query.setInteger(1, idFilm);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            locationValide = false;
        }

        return locationValide;
    }


}
