package com.ssm.controlleradvice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/controllerAdvice" )
public class ControllerAdviceExceptionController {
	@RequestMapping( "/test" )
	@ResponseBody
	public String testException( HttpServletRequest request ) {
		int i = 1;
		int b = i / 0;
		return "hello  ControllerAdvice";
	}
}
