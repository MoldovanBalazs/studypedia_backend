package ro.internteam.studypedia.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private LocalDate date;

//    @Column(name = "userId")
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "description")
    private String description;

    @Column(name = "articleStatus")
    private ArticleStatus articleStatus;

    @Column(name = "articleType")
    private ArticleType articleType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Subject.class)
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArticleStatus getArticleStatus() { return articleStatus; }

    public void setArticleStatus(ArticleStatus articleStatus) { this.articleStatus = articleStatus; }

    public ArticleType getArticleType() { return articleType; }

    public void setArticleType(ArticleType articleType) { this.articleType = articleType; }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
