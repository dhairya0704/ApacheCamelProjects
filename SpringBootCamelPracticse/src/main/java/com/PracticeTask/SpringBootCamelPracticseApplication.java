package com.PracticeTask;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootCamelPracticseApplication {

	public static void main(String[] args) throws Exception{
	 
		ApplicationContext appContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		try {
		CamelContext camelContext = new SpringCamelContext(appContext);
		ProducerTemplate template = camelContext.createProducerTemplate();
		camelContext.start();
		template.sendBody("activemq:test.queue","Hello");
		
			Thread.sleep(2000);
		}catch (Exception e) {
			System.out.println("Exception Caught");
		}
		
		
	}

}
