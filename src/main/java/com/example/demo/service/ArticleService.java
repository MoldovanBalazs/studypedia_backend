package com.example.demo.service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.FacultyDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.model.Article;
import com.example.demo.model.Faculty;
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
