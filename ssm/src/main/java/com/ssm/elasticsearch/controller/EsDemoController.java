package com.ssm.elasticsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/es" )
public class EsDemoController {

	// @Autowired
	// ElasticsearchTemplate elasticsearchTemplate;

	/*
	 * @RequestMapping( "/test" )
	 * 
	 * @ResponseBody public String test( HttpServletRequest request ) { Map<?,
	 * ?> mapping = elasticsearchTemplate.getMapping( "test", "test" );
	 * System.out.println( mapping ); return "ok"; }
	 */
}
