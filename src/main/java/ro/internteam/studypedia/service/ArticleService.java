package ro.internteam.studypedia.service;

import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.ArticleStatus;
import ro.internteam.studypedia.model.ArticleType;
import ro.internteam.studypedia.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void insertArticle(
            String title,
            ArticleType type,
            String description
    ){
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setArticleType(type);
        article.setArticleStatus(ArticleStatus.PENDING);
        article.setDate(LocalDateTime.now());
        this.articleDao.save(article);
    }

    public String updateArticle(Integer articleId, ArticleStatus status){
        Article article = articleDao.findById(articleId).orElse(null);
        if(article != null){
            article.setArticleStatus(status);
            articleDao.save(article);
        }
        return "modified article " + article.getTitle() + " to " + article.getArticleStatus();
    }

    public List getArticlesByType(ArticleType type){
        List<Article> filteredArticles = new ArrayList<>();
        articleDao.findAll().forEach(article -> {
            if(article.getArticleType().equals(type))
                filteredArticles.add(article);
        });
        return filteredArticles;
    }

    public void deleteArticleById(Integer id) {
        articleDao.findAll().forEach(article -> {
            if(article.getId().equals(id)){
                articleDao.delete(article);
            }
        });
    }

}
