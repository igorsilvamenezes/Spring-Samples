package br.com.igormenezes.spring.minicontainer;

public class Main {

	public static void main(String[] args) {
		CustomerRelationOffice customerRelationOffice =
			(CustomerRelationOffice) Container.getComponent("customerRelationOffice");
		
		customerRelationOffice.sendUrgent("to:all#msg:all credit canceled");
		
		customerRelationOffice.sendNormal("to:all#Especial offers Android Phones...");
		customerRelationOffice.sendNormal("to:all#Especial offers Java courses...");
		customerRelationOffice.sendAll();
	}
}