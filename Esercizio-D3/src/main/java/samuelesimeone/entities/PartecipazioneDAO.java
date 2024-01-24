package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Partecipazione x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Partecipazione salvata con successo!");
    }

    public Partecipazione getById (long id){
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Partecipazione non trovata");
            return null;
        }
    }

    public void delete (long id){
        Partecipazione found = em.find(Partecipazione.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Partecipazione non trovata");
        }
    }
}
