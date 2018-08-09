package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.ArticleStatus;
import ro.internteam.studypedia.model.ArticleType;
import ro.internteam.studypedia.model.User;
import ro.internteam.studypedia.model.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
public class ArticleResource {

    @Autowired
    private ArticleDao articleDao;

    @PostMapping(path = "/article")
    public String insertArticol(@RequestParam(value = "name") String name,
                                @RequestParam(value = "description") String description,
                                @RequestParam(value = "type") ArticleType type
//                                @RequestParam(value = "subject") Subject subject,
//                                @RequestParam(value = "user")User user
                                ) {
        Article article = new Article();
        article.setTitle(name);
        article.setDescription(description);
        article.setArticleType(type);
//        article.setSubject(subject);
//        article.setUser(user);
        article.setArticleStatus(ArticleStatus.PENDING);
        article.setDate(LocalDate.now());
        articleDao.save(article);
        return "added article : " + article.getTitle() + " to db with ";
    }

    @PutMapping(path = "/article")
    public String updateStatus(@RequestParam(value = "articleId") Integer articleId,
                               @RequestParam(value = "status") ArticleStatus status){
        Article article = articleDao.findById(articleId).orElse(null);
        if(article != null){
            article.setArticleStatus(status);
            articleDao.save(article);
        }
        return "modified article " + article.getTitle() + " to " + article.getArticleStatus();
    }

    @GetMapping(path = "/article/{id}")
    public Object getArticle(@PathVariable("id") Integer id) {

        return articleDao.findById(id).get();
    }

    @GetMapping(path = "/article/all")
    public Object getArticles() {

        return articleDao.findAll();
    }

    @GetMapping(path = "/typeArticle")
    public Object getArticlesByType(@RequestParam(value = "type") ArticleType type) {
        List<Article> filteredArticles = new ArrayList<>();
        articleDao.findAll().forEach(article -> {
            if(article.getArticleType().equals(type))
                filteredArticles.add(article);
        });
        return filteredArticles;
    }

    @DeleteMapping(path = "/articleDelete/{id}")
    public void deleteArticleById(@PathVariable("id") Integer id) {
        articleDao.findAll().forEach(article -> {
            if(article.getId().equals(id)){
                articleDao.delete(article);
            }
        });
    }
}

















