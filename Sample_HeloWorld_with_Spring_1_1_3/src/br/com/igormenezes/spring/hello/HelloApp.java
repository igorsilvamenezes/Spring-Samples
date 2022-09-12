package br.com.igormenezes.spring.hello;

import java.io.FileInputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class HelloApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		BeanFactory factory =
			new XmlBeanFactory(new FileInputStream("hello.xml"));
		
		GreetingServiceImpl greetingService = 
			(GreetingServiceImpl) factory.getBean("greetingService");
		
		greetingService.sayGreeting();
	}
}