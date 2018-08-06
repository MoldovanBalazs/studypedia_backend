package ro.internteam.studypedia.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author I. Stetco
 */
    @Entity
    @Table(name = "faculty")
    public class Faculty {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

//        @Column(name = "universityId")
        @ManyToOne(targetEntity = University.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private University university;

        /*@ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "facultate_materie", joinColumns = {@JoinColumn(name = "facultate_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "materie_id", nullable = false)})
        private List<Subject> materii  = new ArrayList<>();*/




        @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty", fetch = FetchType.EAGER)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public List<Subject> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Subject> materii) {
        this.materii = materii;
    }*/
}
