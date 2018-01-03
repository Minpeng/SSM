package com.ssm.elasticsearch.repository.impl;

import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import com.ssm.elasticsearch.entity.Article;
import com.ssm.elasticsearch.repository.ArticleRepository;


@Component( "articleRepository" )
public class ArticleRepositoryImpl implements ArticleRepository {

	@Override
	public <S extends Article> S index( S entity ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Article> search( QueryBuilder query ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> search( QueryBuilder query, Pageable pageable ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> search( SearchQuery searchQuery ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> searchSimilar( Article entity, String[] fields, Pageable pageable ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<Article> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Article> findAll( Sort sort ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> findAll( Pageable pageable ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Article> S save( S entity ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Article> Iterable<S> saveAll( Iterable<S> entities ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Article> findById( Long id ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById( Long id ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Article> findAllById( Iterable<Long> ids ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById( Long id ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete( Article entity ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll( Iterable<? extends Article> entities ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> findByTitleAndAuthor( String title, String author ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByTitleOrAuthor( String title, String author ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> findBydescribe( String describe, Pageable page ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> findBydescribeNot( String describe, Pageable page ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> findBydescribeLike( String describe, Pageable page ) {
		// TODO Auto-generated method stub
		return null;
	}

}
