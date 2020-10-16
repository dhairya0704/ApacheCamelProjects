package com.JavaDsl.camel_application;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelTimer {
public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext(); {
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("timer://myTimer?period=2000")
					.setBody()
				    .simple("Hello Camel!, it is ${header.firedTime}")
				    .to("stream:out");;
				}
			});
			context.start();
			Thread.sleep(10000);
		}
	}
}
