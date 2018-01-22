package com.demo.annotation;

public class AnnotationUse {

	@MyAnnotation( name = "pengm", age = 12 )
	public static void getAnnotationInfo( String name, int age ) {
		System.out.println( "annotationInfo:" );
		System.out.println( "name:" + name );
		System.out.println( "age:" + age );
	}

	public static void main( String[] args ) throws Exception {
		final ParseMyAnnotation pm = new ParseMyAnnotation();
		pm.parseMethod( AnnotationUse.class );
	}
}
