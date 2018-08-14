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

    //Daiana
    public List getArticlesByType(String type){
        List<Article> filteredArticles = new ArrayList<>();
        int articleTypeInt = Integer.parseInt(type);
        ArticleType articleType;

        if(articleTypeInt == 0) articleType = ArticleType.NOTE;
        else if(articleTypeInt == 1) articleType = ArticleType.SEMINAR;
        else if(articleTypeInt == 2) articleType = ArticleType.LAB;
        else articleType = ArticleType.EXAM;
        ArticleType finalArticleType = articleType;

        articleDao.findAll().forEach(article -> {
            if(article.getArticleType().equals(finalArticleType))
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