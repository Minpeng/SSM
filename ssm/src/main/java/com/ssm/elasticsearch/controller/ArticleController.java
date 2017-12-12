package com.ssm.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.elasticsearch.entity.Article;
import com.ssm.elasticsearch.service.ArticleService;

@Controller
@RequestMapping( "/article" )
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping( value = "/insertArticle" )
	public Long insertArticle( @RequestBody Article article ) {
		return articleService.insertArticle( article );
	}

	@RequestMapping( value = "/findByTitleAndAuthor" )
	public List<Article> findByTitleAndAuthor( @RequestParam( value = "title" ) String title,
	        @RequestParam( value = "author" ) String author ) {
		return articleService.findByTitleAndAuthor( title, author );
	}

	@RequestMapping( value = "/findByTitleOrAuthor" )
	public List<Article> findByTitleOrAuthor( @RequestParam( value = "title" ) String title,
	        @RequestParam( value = "author" ) String author ) {
		return articleService.findByTitleOrAuthor( title, author );
	}
}
