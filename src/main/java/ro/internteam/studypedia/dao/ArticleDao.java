package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleDao extends CrudRepository<Article, Integer> {
}
