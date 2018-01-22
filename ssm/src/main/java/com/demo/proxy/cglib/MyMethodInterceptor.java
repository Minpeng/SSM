package com.demo.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib 代理
 * 
 * @author pengm
 *
 */
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept( Object object, Method method, Object[] args, MethodProxy methodProxy ) throws Throwable {
		System.out.println( "++++++before " + methodProxy.getSuperName() + "++++++" );
		System.out.println( method.getName() );
		Object o1 = methodProxy.invokeSuper( object, args );
		System.out.println( "++++++after " + methodProxy.getSuperName() + "++++++" );
		return o1;
	}


}
