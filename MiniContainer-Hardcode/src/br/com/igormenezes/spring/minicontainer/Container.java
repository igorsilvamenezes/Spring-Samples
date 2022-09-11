package br.com.igormenezes.spring.minicontainer;

import java.util.HashMap;
import java.util.Map;

public class Container {
	
	static Map<String, Object> components = iniMap();

	private static Map<String, Object> iniMap() {
		components = new HashMap<String, Object>();
		
		DeliveryService deliveryService = new ElectronicDeliveryService();
//		DeliveryService deliveryService = new MailDeliveryService();
		components.put("deliveryService", deliveryService);
		
		CustomerRelationOffice customerRelationOffice =
			new CustomerRelationOffice(deliveryService);
		components.put("customerRelationOffice", customerRelationOffice);
		
		return components;
	}

	public static Object getComponent(String component) {		
		return components.get(component);
	}
}
