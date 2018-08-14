package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.ArticleStatus;
import ro.internteam.studypedia.model.ArticleType;
import ro.internteam.studypedia.service.ArticleService;
import ro.internteam.studypedia.service.UniversityService;

import java.util.List;

@RestController
@CrossOrigin
public class ArticleResource {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UniversityService universityService;


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
    public void insertArticle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "type") ArticleType type,
            @RequestParam(name = "description") String description
    ) {
        this.articleService.insertArticle(title, type, description);
    }

    @GetMapping(path = "/article/all")
    public Object getArticles() {
        return articleDao.findAll();
    }

    //Daiana
    @GetMapping(path = "/article/type")
    public Object getArticlesByType(@RequestParam(value = "type") String type) {
        System.out.println(type);
        return this.articleService.getArticlesByType(type);
    }

    @DeleteMapping(path = "/articleDelete/{id}")
    public void deleteArticleById(@PathVariable("id") Integer id) {
        this.articleService.deleteArticleById(id);
    }

    @PutMapping(path = "/article")
    public void updateStatus(@RequestParam(value = "articleId") Integer articleId,
                             @RequestParam(value = "status") ArticleStatus status) {
        this.articleService.updateArticle(articleId, status);
    }

}