package samuelesimeone.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users autore;

    @ManyToMany
    @JoinTable(name = "blogs_categories", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "blog_id"))

    private Set<Category> categories;

    public BlogPost(String title, String content, Users autore) {
        this.title = title;
        this.content = content;
        this.autore = autore;
    }

    public BlogPost(){}

    public long getId() {
        return id;
    }


    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getAutore() {
        return autore;
    }

    public void setAutore(Users autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", autore=" + autore +
                '}';
    }
}
