package org.proxibanque.lanceur;

import java.util.ArrayList;
import java.util.List;

import org.proxibanque.dao.ClientsDao;
import org.proxibanque.dao.impl.ClientDaoImpl;
import org.proxibanque.dao.impl.CompteDaoImpl;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.service.ClientService;
import org.proxibanque.service.ClientServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception {

//		Client client = new Client();
//		client.setFirstName("tata");
//		client.setLastName("yoda");
//		client.getCompteCourant().setNumeroCompte(client.getCompteCourant().creationNumeroCompteCourant(client));
//		client.getCompteEpargne().setNumeroCompte(client.getCompteEpargne().creationNumeroCompteEpargne(client));
//		System.out.println("String Num CC : " + client.getCompteCourant().creationNumeroCompteCourant(client));
//		System.out.println("Num CC : " + client.getCompteCourant().getNumeroCompte());
		
		ClientsDao clientDao = new ClientDaoImpl();
		ClientService clientService = new ClientServiceImpl();
		CompteDaoImpl compteDao = new CompteDaoImpl();
		Compte compteDebiteur = new CompteCourant();
		Client client = new Client();
		List<Client> reListClient = new ArrayList<Client>();
		
		String numCompteDebiteur = "CS-2017862747-PARIS12-CC";
		String numCompteCrediteur = "DA-2017864217-PARIS12-CE";
		double montantTransfert=200.0;
		
//		reListClient = clientDao.findAll();
//		System.out.println("\n\nClients : " + reListClient + "\n\n");
		
//		List<Compte> reList = new ArrayList<Compte>();
//		reList = compteDao.listeInfosCompteDao();
//		System.out.println("\n\nComptes : " + reList + "\n\n");
		
//		client = clientService.findById(numCompteDebiteur);
//		System.out.println("\n\nClient : " + client + "\n\n");
		
//		compteDebiteur = compteDao.infoCompteCourantDao(numCompteDebiteur);
		System.out.println("\n\nCompte debiteur : " + compteDebiteur + "\n\n");

	}

}
