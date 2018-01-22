package com.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;


public class MyInvocationHandler implements InvocationHandler {
	private HelloProxy helloProxy;

	MyInvocationHandler() {
		super();
	}
	public MyInvocationHandler(HelloProxy helloProxy) {
		super();
		this.helloProxy = helloProxy;
	}
	// 1. 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法
	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

		// 执行目标对象的方法
		System.out.println( ("You said: " + Arrays.toString( args )) );
		return method.invoke( helloProxy, args );


	}



}
