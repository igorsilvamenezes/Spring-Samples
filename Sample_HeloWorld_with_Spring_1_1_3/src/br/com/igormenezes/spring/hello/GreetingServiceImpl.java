package br.com.igormenezes.spring.hello;

public class GreetingServiceImpl implements GreetingService {
	private String greeting;
	
	public GreetingServiceImpl(){}
	
	public GreetingServiceImpl(String greeting){
		this.greeting = greeting;
	}
	
	public void sayGreeting(){
		System.out.println(greeting);
	}
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}	
}