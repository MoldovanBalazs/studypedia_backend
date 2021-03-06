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

    public String updateArticle(String articleId, String status){
        Integer id = Integer.parseInt(articleId);
        Article article = articleDao.findById(id).orElse(null);
        int articleStatusInt = Integer.parseInt(status);
        ArticleStatus articleStatus;

        if(articleStatusInt == 0) articleStatus = ArticleStatus.DENIED;
        else if(articleStatusInt == 1) articleStatus = ArticleStatus.ACCEPTED;
        else articleStatus = ArticleStatus.PENDING;
        ArticleStatus finalArticleStatus = articleStatus;

        article.setArticleStatus(finalArticleStatus);
        articleDao.save(article);

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
    // Practic tot Daiana
    public List getArticlesByStatus(String status){
        List<Article> filteredArticles = new ArrayList<>();
        int articleStatusInt = Integer.parseInt(status);
        ArticleStatus articleStatus = null;

        if(articleStatusInt == 0) articleStatus = ArticleStatus.DENIED;
        else if(articleStatusInt == 1) articleStatus = ArticleStatus.ACCEPTED;
        else if(articleStatusInt == 2) articleStatus = ArticleStatus.PENDING;
        ArticleStatus finalArticleStatus = articleStatus;

        articleDao.findAll().forEach(article -> {
            if(article.getArticleStatus().equals(finalArticleStatus)) {
                filteredArticles.add(article);
            }
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