package com.demo.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibProxy {
	public static void main( String[] args ) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass( HelloCglibProxy.class );
		enhancer.setCallback( new MyMethodInterceptor() );

		HelloCglibProxy hello = (HelloCglibProxy)enhancer.create();
		System.out.println( hello.sayHello( "Cglib" ) );
	}
}
