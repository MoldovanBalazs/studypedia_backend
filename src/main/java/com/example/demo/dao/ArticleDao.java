package com.example.demo.dao;

import com.example.demo.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleDao extends CrudRepository<Article, Integer> {
}
