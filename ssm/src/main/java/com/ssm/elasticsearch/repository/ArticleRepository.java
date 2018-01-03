package com.ssm.elasticsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ssm.elasticsearch.entity.Article;


// @Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

	List<Article> findByTitleAndAuthor( String title, String author );

	List<Article> findByTitleOrAuthor( String title, String author );

	Page<Article> findBydescribe( String describe, Pageable page );

	Page<Article> findBydescribeNot( String describe, Pageable page );

	Page<Article> findBydescribeLike( String describe, Pageable page );
}
