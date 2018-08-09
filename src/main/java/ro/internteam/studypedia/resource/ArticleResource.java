package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;
import ro.internteam.studypedia.service.ArticleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @PostMapping(path = "/insertArticle")
    public String insertArticle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "type") ArticleType type,
            @RequestParam(name = "description") String description
    ){
        this.articleService.insertArticle(title, type, description);
        return "added Article " + title;
    }

    @PutMapping(path = "/article")
    public void updateStatus(@RequestParam(value = "articleId") Integer articleId,
                               @RequestParam(value = "status") ArticleStatus status){
        this.articleService.updateArticle(articleId,status);
    }

    @GetMapping(path = "/article/all")
    public Object getArticles() {

        return articleDao.findAll();
    }

    @GetMapping(path = "/typeArticle")
    public Object getArticlesByType(@RequestParam(value = "type") ArticleType type) {
        return this.articleService.getArticlesByType(type);
    }

    @GetMapping(path = "/user/{id}/articles")
    public List<Article> getUserArticle(@PathVariable Integer id) {
        return userDao.findById(id).get().getArticles();
    }

    @DeleteMapping(path = "/articleDelete/{id}")
    public void deleteArticleById(@PathVariable("id") Integer id) {
        this.articleService.deleteArticleById(id);
    }

}