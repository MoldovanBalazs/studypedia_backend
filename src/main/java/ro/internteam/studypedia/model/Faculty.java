package ro.internteam.studypedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

        @JsonIgnore
        @ManyToOne(targetEntity = University.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private University university;

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

    public University getUniversity(){return this.university;}

    public void setUniversity(University university){
            this.university = university;
    }

}
