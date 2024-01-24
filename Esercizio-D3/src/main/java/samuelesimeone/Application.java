package samuelesimeone;

import com.github.javafaker.Faker;
import samuelesimeone.entities.*;
import samuelesimeone.eventi.Evento;
import samuelesimeone.eventi.EventoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio_d3");
    private static Faker faker = new Faker(Locale.ITALY);
    private static Random rdm = new Random();

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        System.out.println("Esercizio-D3");

        try{
            EventoDAO eb = new EventoDAO(em);
            PersonaDAO pb = new PersonaDAO(em);
            PartecipazioneDAO pzb = new PartecipazioneDAO(em);
            LocationDAO lb = new LocationDAO(em);


            Persona utente1 = new Persona(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now().minusYears(23), Genere.m);
            Evento evento1 = new Evento(faker.lorem().sentence(4), LocalDate.now().plusMonths(4), faker.lorem().sentence(5), rdm.nextLong(1000));
            Location location1 = new Location(faker.lorem().word(), faker.country().capital());

//            pb.save(utente1);
//            eb.save(evento1);
//            lb.save(location1);

            Persona p = pb.getById(1);
            Evento e = eb.getById(2);
            Partecipazione partecipazione1 = new Partecipazione(p, e, Stato.confermata);
//            pzb.save(partecipazione1);

            System.out.println(p.getPartecipaziones());
            System.out.println(e.getPartecipaziones());

            Evento e1 = eb.getById(5);
            Location l = lb.getById(3);

            l.setEventi(new HashSet<>(Arrays.asList(e, e1)));
//            lb.save(l);

            e1.getLocations().forEach(System.out::println);
            l.getEventi().forEach(System.out::println);




        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
