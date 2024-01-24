package samuelesimeone.eventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Evento x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Evento salvato con successo!");
    }

    public Evento getById (long id){
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Evento non trovato");
            return null;
        }
    }

    public void delete (long id){
        Evento found = em.find(Evento.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Evento non trovato");
        }
    }
}
