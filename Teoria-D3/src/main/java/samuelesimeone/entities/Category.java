package samuelesimeone.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categorys")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    @ManyToMany
    @JoinTable(name = "blogs_categories", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<BlogPost> blogPosts;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
