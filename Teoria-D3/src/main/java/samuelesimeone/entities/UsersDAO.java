package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsersDAO {
    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Users x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Nuovo studente salvato");
    };

    public Users findById(long id){
        Users foud = em.find(Users.class, id);
        return foud;
    };

    public void deleteById(long id){
        Users found = em.find(Users.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            System.out.println("Utente rimosso " + found);
            em.remove(found);
            transaction.commit();
        }else{
            System.out.println("Studente non trovato");
        }
    };
}
