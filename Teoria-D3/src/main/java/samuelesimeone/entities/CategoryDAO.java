package samuelesimeone.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

public class CategoryDAO {
    private final EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Category x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Nuovo documento salvato");
    };

    public Category findById(long id){
        Category foud = em.find(Category.class, id);
        return foud;
    };

    public void deleteById(long id){
        Category found = em.find(Category.class, id);

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

    public void insertMany (Set<String> categories){
        for (String cat : categories){
            EntityTransaction transaction = em.getTransaction();
            Category c = new Category(cat);
            transaction.begin();
            em.persist(c);
            transaction.commit();
        }
        System.out.println("Categorie inserite");
    }
}
