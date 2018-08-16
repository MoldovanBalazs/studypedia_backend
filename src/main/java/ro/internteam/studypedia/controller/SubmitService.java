package ro.internteam.studypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static ro.internteam.studypedia.model.ArticleStatus.PENDING;

@RestController
@CrossOrigin
public class SubmitService {
    @Autowired
    private UserDao userDao;

    @Autowired
    ArticleDao articleDao;

    @Autowired
    SubjectDao subjectDao;

    @PostMapping(path = "/submit_entry")
    public String addEntry(@RequestBody final SubmitEntry body) throws IOException {

        Article article = new Article();
        article.setDescription(body.getDescription());
        article.setTitle(body.getTitle());
        article.setDate(LocalDateTime.now());
        article.setArticleStatus(PENDING);
        article.setArticleType(ArticleType.valueOf(body.getArticleType().toUpperCase()));

        for (Subject subject : subjectDao.findAll()) {
            if (subject.getName().equals(body.getSubject())) {
                article.setSubject(subject);
                break;
            }
        }

        User user = userDao.findById(body.getUserId()).get();
        article.setUser(user);

        articleDao.save(article);

        return article.getId().toString();


    }

    @PostMapping("/submit_file/{id}")
    @ResponseBody
    public String uploadPhoto(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "error";
        }
        Article article = articleDao.findById(id).get();
        article.setFile(file.getBytes());

        articleDao.save(article);

        return "succes";
    }

}

