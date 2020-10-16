package com.JavaDsl.camel_application;

import org.apache.camel.CamelContext;

import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello Camel!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
//        System.out.println( "Hello World!" );

    	
    	CamelContext context=new DefaultCamelContext();
    	context.addRoutes(new AppRoute());
    	context.start();
    	
    	
    	
    }
}
