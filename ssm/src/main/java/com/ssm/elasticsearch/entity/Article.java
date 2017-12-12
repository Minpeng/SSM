package com.ssm.elasticsearch.entity;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "test", type = "article" )
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String title;

	private String describe;

	private String author;

	private int score;

	public long getId() {
		return id;
	}

	public void setId( long id ) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe( String describe ) {
		this.describe = describe;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor( String author ) {
		this.author = author;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "Article [id=" );
		builder.append( id );
		builder.append( ", title=" );
		builder.append( title );
		builder.append( ", describe=" );
		builder.append( describe );
		builder.append( ", author=" );
		builder.append( author );
		builder.append( "]" );
		return builder.toString();
	}

	public int getScore() {
		return score;
	}

	public void setScore( int score ) {
		this.score = score;
	}

}
