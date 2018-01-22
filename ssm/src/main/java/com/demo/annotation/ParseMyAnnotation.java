package com.demo.annotation;

import java.lang.reflect.Method;

/**
 * 注解解析器
 * 
 * @author pengm
 * @date 2018年1月22日上午10:19:54
 */
public class ParseMyAnnotation {
	/**
	 * 
	 * @param clazz 为注解所在的目标类
	 * @throws Exception
	 */
	public void parseMethod( final Class<?> clazz ) throws Exception {
		// 生成目标类的一个实例
		final Object obj = clazz.getConstructor( new Class[] {} ).newInstance( new Object[] {} );
		// 得到目标类的方法集
		final Method[] methods = clazz.getDeclaredMethods();
		for( final Method method : methods ) {
			// 获取方法上的注解，同时判断是否存在
			final MyAnnotation my = method.getAnnotation( MyAnnotation.class );
			if( null != my ) {
				// 如果存在则将注解上的值传递个目标方法，并执行。
				method.invoke( obj, my.name(), my.age() );

			}
		}
	}
}
