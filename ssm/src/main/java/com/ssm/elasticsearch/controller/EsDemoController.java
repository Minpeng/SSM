package com.ssm.elasticsearch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/es")
public class EsDemoController {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request) {

		// 使用queryStringQuery完成单字符串查询
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
				QueryBuilders.queryStringQuery("测试")).build();
		;

		List<EsDemoController> queryForList = elasticsearchTemplate
				.queryForList(searchQuery, EsDemoController.class);
		System.out.println(queryForList);
		return "ok";
	}

}
