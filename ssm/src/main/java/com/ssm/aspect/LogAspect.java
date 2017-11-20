package com.ssm.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
	
	public LogAspect() {

	}

	@Pointcut( "execution(* com.ssm.controller.*.*(..))" )
	private void pointcut() {

	}

	@AfterReturning( value = "(pointcut())", returning = "returnVal" )
	public void after( JoinPoint jp, Object returnVal ) {
		System.err.println( "11111111111111111111111" );
		try {
			Class clazz = jp.getTarget().getClass();

			Annotation clazzAnno = clazz.getAnnotation( Controller.class );

			if( clazzAnno == null ) {
				return;
			}

			MethodSignature signature = (MethodSignature)jp.getSignature();

			Method m = signature.getMethod();

			Annotation requestMappingAnno = m.getAnnotation( RequestMapping.class );

			Annotation responseBodyAnno = m.getAnnotation( ResponseBody.class );

			if( requestMappingAnno != null && responseBodyAnno == null ) {

				Subject subject = SecurityUtils.getSubject();

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
				HttpServletRequest request = requestAttributes.getRequest();

				if( request != null && subject != null ) {



					System.err.println( "requset:" + request );
					System.err.println( "subject：" + subject );
				}
			}

		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
