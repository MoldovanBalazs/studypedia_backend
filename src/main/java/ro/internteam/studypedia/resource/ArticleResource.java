package ro.internteam.studypedia.resource;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.ArticleStatus;
import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;
import ro.internteam.studypedia.service.ArticleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class ArticleResource {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleService articleService;

    @GetMapping(path = "/user/{id}/articles")
    public List<Article> getUserArticle(@PathVariable Integer id) {
        return userDao.findById(id).get().getArticles();
    }


    @GetMapping(path = "/articles")
    public List<Article> testArticle() {
        Integer id = new Integer(1);
        return getUserArticle(id);
    }

    @PostMapping(path = "/insertArticle")
    public String insertArticle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "date") String date,
            @RequestParam(name = "description") String description
    ){
        this.articleService.insertArticle(title, date, description);
        return "added Article " + title;

    }

    @PutMapping(path = "/articleUpdate")
    public String updateStatus(
            @RequestParam(value = "articleId") Integer articleId,
            @RequestParam(value = "status") ArticleStatus status
    )
    {
        return "modified article " + articleId + " to " + status;
    }

    @GetMapping(path = "/articles/all")
    public Object getArticles(){
        return this.articleService.getArticles();
    }

}
