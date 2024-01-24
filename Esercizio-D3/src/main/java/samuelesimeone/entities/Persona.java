package samuelesimeone.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String e_mail;
    private LocalDate data_di_nascita;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipaziones;

    public Persona(String nome, String cognome, String e_mail, LocalDate data_di_nascita, Genere genere) {
        this.nome = nome;
        this.cognome = cognome;
        this.e_mail = e_mail;
        this.data_di_nascita = data_di_nascita;
        this.genere = genere;
    }

    public Persona() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public List<Partecipazione> getPartecipaziones() {
        return partecipaziones;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", genere=" + genere +
                '}';
    }
}
