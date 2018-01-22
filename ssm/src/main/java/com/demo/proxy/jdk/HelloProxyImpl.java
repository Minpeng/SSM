package com.demo.proxy.jdk;

public class HelloProxyImpl implements HelloProxy {

	@Override
	public String sayHello( String str ) {
		return str + "helloProxy";
	}

}
