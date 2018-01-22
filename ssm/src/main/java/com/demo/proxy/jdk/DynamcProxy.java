package com.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamcProxy {
	public static void main( String[] args ) {

		HelloProxy helloProxy = new HelloProxyImpl();
		InvocationHandler invocationHandler = new MyInvocationHandler( helloProxy );

		HelloProxy helloProxyProxy = (HelloProxy)Proxy.newProxyInstance( helloProxy.getClass().getClassLoader(),
		    helloProxy.getClass().getInterfaces(), invocationHandler );
		System.out.println( helloProxyProxy.sayHello( "11111" ) );
	}
}
