package com.example.demo.resource;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.FacultyDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.dao.UniversityDao;
import com.example.demo.model.Article;
import com.example.demo.model.Faculty;
import com.example.demo.model.University;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin
public class ArticleResource {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private UniversityDao universityDao;

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private FacultyService facultyService;

    @GetMapping(path = "/insertArticol")
    public String insertArticol() {
        Article article = new Article();
        article.setTitle(new Random().nextInt() + " nume ");
        article.setDescription(new Random().nextInt() + " descriere ");
        articleDao.save(article);

        return "added article : " + article.getTitle() + " to db";
    }

    @GetMapping(path = "/university/all")
    public Object getUniversities() {
        return universityDao.findAll();
    }

    @PostMapping(path = "/insertFaculty")
    public String insertFaculty(
            /*@RequestParam(name = "facultyName") String facultyName,
            @RequestParam(name = "universityId") Integer universityId*/
            ) {
        /*
        Faculty newFaculty = new Faculty();
        newFaculty.setDescription("Description 1");
        newFaculty.setName("Facultatea 1");
        University university = universityDao.findById(1).orElse(null);
        facultyDao.save(newFaculty);
        university.addFaculty(newFaculty);
        return "added faculty: " + newFaculty.getName() + "to db";
        */
        this.facultyService.saveFaculty("Facultatea 1", "Universitatea Timisoara");
        return "added faculty: Facultatea 1 to db";
    }

    @PostMapping(path = "/insertUniversity")
    public Object insertUniversity(
            @RequestParam(name = "universityName") String universityName
    ){
        University newUniversity = new University();
        newUniversity.setName(universityName);
        universityDao.save(newUniversity);
        return "added University: " + universityName;
    }

    @GetMapping(path = "/getArticol/{id}")
    public Object getArticol(@PathVariable("id") Integer id) {
        return articleDao.findById(id).get();
    }

}
