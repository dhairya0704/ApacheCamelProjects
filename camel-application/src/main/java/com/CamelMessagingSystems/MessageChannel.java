package com.CamelMessagingSystems;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MessageChannel {
 
	public static void main(String args[]) throws Exception {
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("/input.txt")
			    .to("stream:out");
				
			}
		});

//		ProducerTemplate template = context.createProducerTemplate();
		context.start();
//		template.sendBody("timer://myTimer?period=2000","Hello Camel!");
		Thread.sleep(1000);
			
	}
}
