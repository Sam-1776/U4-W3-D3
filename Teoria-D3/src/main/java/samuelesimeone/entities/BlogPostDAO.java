package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BlogPostDAO {
    private final EntityManager em;

    public BlogPostDAO(EntityManager em) {
        this.em = em;
    }

    public void save(BlogPost x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Nuovo documento salvato");
    };

    public BlogPost findById(long id){
        BlogPost foud = em.find(BlogPost.class, id);
        return foud;
    };

    public void deleteById(long id){
        BlogPost found = em.find(BlogPost.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            System.out.println("Documento rimosso " + found);
            em.remove(found);
            transaction.commit();
        }else{
            System.out.println("Documento non trovato");
        }
    };
}
