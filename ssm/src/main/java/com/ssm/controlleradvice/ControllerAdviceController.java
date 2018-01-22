package com.ssm.controlleradvice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerAdviceController {

	@ExceptionHandler( Exception.class )
	@ResponseBody
	public String handleBizExp( HttpServletRequest request, Exception ex ) {
		System.out.println( "补货到异常,request:" + request + "Exception:" + ex );
		return "error:" + ex;
	}
}
