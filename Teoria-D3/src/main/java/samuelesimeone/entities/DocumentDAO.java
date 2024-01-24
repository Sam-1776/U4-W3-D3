package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DocumentDAO {
    private final EntityManager em;

    public DocumentDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Document x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Nuovo documento salvato");
    };

    public Document findById(long id){
        Document foud = em.find(Document.class, id);
        return foud;
    };

    public void deleteById(long id){
        Document found = em.find(Document.class, id);

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
