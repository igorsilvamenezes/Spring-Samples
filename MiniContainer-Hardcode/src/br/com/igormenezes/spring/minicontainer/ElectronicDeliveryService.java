package br.com.igormenezes.spring.minicontainer;

public class ElectronicDeliveryService implements DeliveryService{

	@Override
	public void send(String message) {
		System.out.println("Send SMS:" + message);		
	}
}