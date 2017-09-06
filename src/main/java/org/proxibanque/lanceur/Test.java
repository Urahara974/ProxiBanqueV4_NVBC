package org.proxibanque.lanceur;

import org.proxibanque.model.Client;
import org.proxibanque.service.ClientService;

public class Test {

	public static void main(String[] args) {

		Client client = new Client();
		client.setFirstName("tata");
		client.setLastName("yoda");
		client.getCompteCourant().setNumeroCompte(client.getCompteCourant().creationNumeroCompteCourant(client));
		client.getCompteEpargne().setNumeroCompte(client.getCompteEpargne().creationNumeroCompteEpargne(client));
		System.out.println("String Num CC : " + client.getCompteCourant().creationNumeroCompteCourant(client));
		System.out.println("Num CC : " + client.getCompteCourant().getNumeroCompte());

	}

}
