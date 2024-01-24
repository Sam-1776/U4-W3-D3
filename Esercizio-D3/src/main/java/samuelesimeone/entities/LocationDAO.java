package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Location x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Location salvata con successo!");
    }

    public Location getById (long id){
        Location found = em.find(Location.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Location non trovata");
            return null;
        }
    }

    public void delete (long id){
        Location found = em.find(Location.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Location non trovata");
        }
    }
}
