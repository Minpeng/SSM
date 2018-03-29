package com.ssm.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.demo.annotation.MyAnnotation;

/**
 * 注解aop
 * 
 * @author pengm
 * @date 2018年3月23日下午5:09:34
 */
@Aspect
@Component
public class MyAnnotationAop {

	@Pointcut( value = "@annotation( com.demo.annotation.MyAnnotation )" )
	private void cutMyAnnotation() {

	}

	@Around( value = "cutMyAnnotation()" )
	public Object doMyAnnotation( ProceedingJoinPoint point ) throws Throwable {
		MethodSignature ms = (MethodSignature)point.getSignature();
		Method method = ms.getMethod();
		MyAnnotation myAnnotation = method.getAnnotation( MyAnnotation.class );
		int age = myAnnotation.age();
		String name = myAnnotation.name();
		System.out.println( "doMyAnnotation..." );
		System.out.print( " age:" + age );
		System.out.print( " name:" + name );
		return null;
	}
}
