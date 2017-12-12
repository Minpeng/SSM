package com.ssm.elasticsearch.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssm.elasticsearch.entity.Article;
import com.ssm.elasticsearch.repository.ArticleRepository;
import com.ssm.elasticsearch.service.ArticleService;

@Service( "articleService" )
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger( ArticleServiceImpl.class );

	private static final Integer pageNumber = 0;

	private static final Integer pageSize = 10;

	Pageable pageable = new PageRequest( pageNumber, pageSize );
	@Override
	public Long insertArticle( Article article ) {
		Article articleResult = articleRepository.save(article);
		return articleResult.getId();
		
	}

	@Override
	public List<Article> findByTitleAndAuthor( String title, String author ) {
		return articleRepository.findByTitleAndAuthor( title, author );
	}

	@Override
	public List<Article> findByTitleOrAuthor( String title, String author ) {
		return articleRepository.findByTitleOrAuthor( title, author );
	}

	@Override
	public Page<Article> findBydescribe( String describe, Pageable page ) {
		return (Page<Article>)articleRepository.findBydescribe( describe, page ).getContent();
	}

	@Override
	public Page<Article> findBydescribeNot( String describe, Pageable page ) {
		return (Page<Article>)articleRepository.findBydescribeNot( describe, page ).getContent();
	}

	@Override
	public Page<Article> findBydescribeLike( String describe, Pageable page ) {
		return (Page<Article>)articleRepository.findBydescribeLike( describe, page ).getContent();
	}

}
