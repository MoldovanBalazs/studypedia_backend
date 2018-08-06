package ro.internteam.studypedia.service;

import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SubjectDao subjectDao;


    @Autowired
    private FacultyDao facultyDao;

    @GetMapping(path = "/insertArticol")
    public String insertArticol() {
        Article article = new Article();
        article.setTitle(new Random().nextInt() + " nume ");
        article.setDescription(new Random().nextInt() + " descriere ");
        articleDao.save(article);

        return "added article : " + article.getTitle() + " to db";
    }

    @GetMapping(path = "/getArticol/{id}")
    public Object getArticol(@PathVariable("id") Integer id) {

        return articleDao.findById(id).get();
    }

    @GetMapping(path = "/insertMaterie")
    public void insertMaterie() {
//
    }


    @GetMapping(path = "/insertFavorite")
    public void insertFavorite() {

    }

    @PostMapping(path = "/insertFacultate")
    public void insertFacultate(@RequestParam(name = "faculty") Faculty faculty) {

    }
}
