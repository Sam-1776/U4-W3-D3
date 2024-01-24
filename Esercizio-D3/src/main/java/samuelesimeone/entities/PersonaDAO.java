package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Persona x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Persona salvata con successo!");
    }

    public Persona getById (long id){
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Persona non trovata");
            return null;
        }
    }

    public void delete (long id){
        Persona found = em.find(Persona.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Persona non trovata");
        }
    }
}
