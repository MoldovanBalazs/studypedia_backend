package ro.internteam.studypedia.resource;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;

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
    private ArticleDao articleDao;

    @GetMapping(path = "/user/{id}/articles")
    public List<Article> getUserArticle(@PathVariable Integer id) {
        return userDao.findById(id).get().getArticles();
    }


    @GetMapping(path = "/articles")
    public List<Article> testArticle() {
        Integer id = new Integer(1);
        return getUserArticle(id);
    }

    @PostMapping(path = "/articleinsert")
    public String insertArticles() {
        User user = userDao.findById(8).get();
        for(int i = 0; i < 15; i++){
            Article article = new Article();
            article.setTitle( "Article no" + new Random().nextInt());
            article.setDescription("Description hash of this article is" + new Random().nextInt());
            article.setUser(user);
            article.setDate(LocalDateTime.now());
            articleDao.save(article);
        }
        return "Articles saved successfully";
    }
}
