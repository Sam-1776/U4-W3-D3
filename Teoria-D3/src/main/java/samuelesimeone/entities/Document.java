package samuelesimeone.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    private long id;

    private LocalDate issueDate;
    @Column(length = 2)
    private String country;
    private String code;

    @OneToOne(mappedBy = "document")
    private Users user;

    public Document(LocalDate issueDate, String country, String code) {
        this.issueDate = issueDate;
        this.country = country;
        this.code = code;
    };
    public Document(){};

    public long getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", country='" + country + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
