package br.com.igormenezes.spring.minicontainer;

public class MailDeliveryService implements DeliveryService {

	@Override
	public void send(String message) {
		System.out.println("Send mail:" + message);		
	}
}
