package ro.internteam.studypedia.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;
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

    @GetMapping(path = "/articleid")
    public Object getArticleById(@RequestParam String id) {
        return articleDao.findById(Integer.valueOf(id));
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
    public Object getArticlesByType(@RequestParam String type) {
        System.out.println(type);
        return this.articleService.getArticlesByType(type);
    }

    @GetMapping(path = "/article/status")
    public Object getArticlesByStatus(@RequestParam(value = "status") String status) {
        System.out.println(status);
        return this.articleService.getArticlesByStatus(status);
    }

    @DeleteMapping(path = "/articleDelete/{id}")
    public void deleteArticleById(@PathVariable("id") Integer id) {
        this.articleService.deleteArticleById(id);
    }

    @PutMapping(path = "/article")
    public void updateStatus(@RequestParam String id,
                               @RequestParam String status){
        this.articleService.updateArticle(id,status);
    }

}