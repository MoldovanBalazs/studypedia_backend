package ro.internteam.studypedia.service;

import ro.internteam.studypedia.dao.ArticleDao;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.model.Article;
import ro.internteam.studypedia.model.ArticleStatus;
import ro.internteam.studypedia.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            String date,
            String description
    ){
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        /**TO DO
         * - convert String date to LocalDateTime;
         * */

        this.articleDao.save(article);
    }

    public Object getArticles(){
        return this.articleDao.findAll();
    }

    public void updateArticle(Integer articleId, ArticleStatus status){
        Article article = articleDao.findById(articleId).orElse(null);
        if(article != null){
            article.setArticleStatus(status);
            articleDao.save(article);
        }
    }

}
