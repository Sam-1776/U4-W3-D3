package samuelesimeone.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private long id;
    // UUID genera come id una stringa univoca (consigliato il suo uso)
    private String name;
    private String surname;
    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @OneToMany(mappedBy = "autore")
    @OrderBy("title ASC")
    private List<BlogPost> blogPosts;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Users(){
    }

    public Users(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.status = Status.active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
