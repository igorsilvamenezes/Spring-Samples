package br.com.igormenezes.spring.minicontainer;

import java.util.ArrayList;

public class CustomerRelationOffice {
	DeliveryService deliveryService = null;

	ArrayList<String> messages = new ArrayList<String>();
	
	public CustomerRelationOffice(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public void sendUrgent(String message){
		deliveryService.send(message);
	}
	
	public void sendNormal(String message){
		messages.add(message);
		if(messages.size() > 10){
			sendAll();
		}
	}
	
	public void sendAll(){
		for(String message : messages){
			deliveryService.send(message);
		}
		
		messages = new ArrayList<String>();
	}
}