package ro.internteam.studypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;

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
    public String addEntry(@RequestBody final SubmitEntry submitEntry) {

        Article article = new Article();
        article.setDescription(submitEntry.getDescription());
        article.setTitle(submitEntry.getTitle());
        article.setDate(LocalDateTime.now());
        article.setArticleStatus(PENDING);
        article.setArticleType(ArticleType.valueOf(submitEntry.getArticleType().toUpperCase()));

        for (Subject subject : subjectDao.findAll()) {
            if (subject.getName().equals(submitEntry.getSubject())) {
                article.setSubject(subject);
                break;
            }
        }

        User user = userDao.findById(submitEntry.getUserId()).get();
        article.setUser(user);

        articleDao.save(article);

        return "succes";


    }

}

