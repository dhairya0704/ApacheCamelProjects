package com.JavaDsl.camel_application;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class SimpleHelloCamel {

	public static void main(String args[]) throws Exception{
		
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("activemq:queue:test.queue").to("stream:out");
				
			}
		});
	}
}