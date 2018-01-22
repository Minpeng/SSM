package com.demo.proxy.jdk;

public class StaticHelloProxyImpl implements HelloProxy {

	private HelloProxy helloProxy = new HelloProxyImpl();

	@Override
	public String sayHello( String str ) {
		System.out.println( "静态代理" );
		return helloProxy.sayHello( str );
	}

}
