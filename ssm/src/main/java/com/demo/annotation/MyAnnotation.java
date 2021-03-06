package com.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author pengm
 * @date 2018年1月22日上午10:16:57 自定义注解
 */

// 说明该注解将被包含在javadoc中
@Documented
// 这个注解可以是类注解，也可以是方法的注解
@Target( { ElementType.TYPE, ElementType.METHOD } )
// 定义的这个注解是注解会在class字节码文件中存在，在运行时可以通过反射获取到。
@Retention( RetentionPolicy.RUNTIME )
// 子类可以继承父类中的该注解
@Inherited
// 为注解定义一个方法即为注解定义了一个元素，返回的默认值为hell world
public @interface MyAnnotation {
	public String name() default "hello world";

	public int age() default 10;
}
