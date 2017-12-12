package com.ssm.elasticsearch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.elasticsearch.entity.Article;

@Controller
@RequestMapping("/es")
public class EsDemoController {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request) {

		String searchWord = request.getParameter( "word" );
		// 使用queryStringQuery完成单字符串查询
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
		    QueryBuilders.queryStringQuery( searchWord ) ).build();


		List<Article> queryForList = elasticsearchTemplate.queryForList( searchQuery, Article.class );
		System.out.println(queryForList);
		return queryForList.toString();
	}

	@RequestMapping( "/insert" )
	@ResponseBody
	public String insert( HttpServletRequest request ) {
		String index = "test";
		String type = "article";
		Client esClient = elasticsearchTemplate.getClient();
		Map<String, Object> soucre = new HashMap<>();
		BulkRequestBuilder bulkRequest = esClient.prepareBulk();
		bulkRequest.add( esClient.prepareIndex( index, type ).setSource( soucre ) );
		String searchWord = request.getParameter( "word" );
		// 使用queryStringQuery完成单字符串查询
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery( QueryBuilders.queryStringQuery( searchWord ) ).build();

		List<Article> queryForList = elasticsearchTemplate.queryForList( searchQuery, Article.class );
		System.out.println( queryForList );
		return queryForList.toString();
	}
}
