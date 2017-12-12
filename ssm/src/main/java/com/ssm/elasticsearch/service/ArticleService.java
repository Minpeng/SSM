package com.ssm.elasticsearch.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ssm.elasticsearch.entity.Article;

public interface ArticleService {

	Long insertArticle( Article city );

	List<Article> findByTitleAndAuthor( String title, String author );

	List<Article> findByTitleOrAuthor( String title, String author );

	Page<Article> findBydescribe( String describe, Pageable page );

	Page<Article> findBydescribeNot( String describe, Pageable page );

	Page<Article> findBydescribeLike( String describe, Pageable page );
}
