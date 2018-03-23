package com.ssm.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.annotation.MyAnnotation;

/**
 * Created by pengmin on 2017/5/6.
 */
@Controller
@RequestMapping("/test")
public class testController {

    @RequestMapping("/index")
    @ResponseBody
	@MyAnnotation( name = "index", age = 12 )
    public  String test(HttpServletRequest request){

		return "test";
    }

	@RequestMapping( "/something" )
	public ResponseEntity<String> handle( HttpEntity<byte[]> requestEntity ) throws UnsupportedEncodingException {
		String requestHeader = requestEntity.getHeaders().getFirst( "MyRequestHeader" );
		byte[] requestBody = requestEntity.getBody();
		// do something with request header and body
		System.out.println( requestBody );
		System.out.println( "----" );
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set( "MyResponseHeader", "MyValue" );
		return new ResponseEntity<String>( "Hello World", responseHeaders, HttpStatus.CREATED );
	}
}