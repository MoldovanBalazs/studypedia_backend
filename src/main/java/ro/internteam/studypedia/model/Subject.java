package ro.internteam.studypedia.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author I. Stetco
 */
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject", fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "branch_subject", joinColumns = {@JoinColumn(name = "subjectId", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "branchId", nullable = false)})
    private List<Branch> branches = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
