package com.JavaDsl.camel_application;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaSimpleCamel {

		public static void main(String args[]) throws Exception {
			
			CamelContext context=new DefaultCamelContext();
			
			context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false")); // this is used to store the text in memory and not in file.
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					// TODO Auto-generated method stub
					from("activemq:queue:test.queue")
					.to("stream:out");
					
				}
			});
			
			ProducerTemplate template = context.createProducerTemplate();
			context.start();
			template.sendBody("activemq:test.queue", "Hello Camel!");
			Thread.sleep(2000);
		}
}
