package samuelesimeone;

import samuelesimeone.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("teoria_d3");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UsersDAO ud = new UsersDAO(em);
        DocumentDAO dD = new DocumentDAO(em);
        BlogPostDAO bD = new BlogPostDAO(em);
        CategoryDAO cD = new CategoryDAO(em);

        System.out.println("Hello World!");

        Users Aldo = new Users("Aldo", "Baglio");
        Document first = new Document(LocalDate.now(), "IT", "fwvf2837fivbw");
//        dD.save(first);
        Aldo.setDocument(first);
//        ud.save(Aldo);

        Users u = ud.findById(2);
        System.out.println(u);
        System.out.println(u.getDocument());

        Document d = dD.findById(1);
        System.out.println(d);
        System.out.println(d.getUser());

        BlogPost primo = new BlogPost("React", "Meglio il front",u);
//        bD.save(primo);
        BlogPost java = new BlogPost("Java", "programmazione OOP",u);
//        bD.save(java);
        BlogPost react = bD.findById(3);
        System.out.println(react);
        System.out.println(u.getBlogPosts());

//        cD.insertMany(new HashSet<>(Arrays.asList("Java", "Back-End", "React", "Angular")));

        Category JavaC = cD.findById(5);
        Category ReactC = cD.findById(7);
        BlogPost javaPost = bD.findById(4);

        // Fare sempre i controlli
        javaPost.setCategories(new HashSet<>(Arrays.asList(JavaC, ReactC)));
//        bD.save(javaPost);
        javaPost.getCategories().forEach(System.out::println);
        ReactC.getBlogPosts().forEach(System.out::println);

        em.close();
        emf.close();
    }

}
