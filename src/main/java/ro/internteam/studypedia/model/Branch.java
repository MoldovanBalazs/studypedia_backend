package ro.internteam.studypedia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Faculty.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Faculty faculty;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "branch_subject", joinColumns = {@JoinColumn(name = "branch_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "subject_id", nullable = false)})
    private List<Subject> subjects = new ArrayList<>();


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

    public Faculty getFaculty() {
        return faculty;
    }


    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
