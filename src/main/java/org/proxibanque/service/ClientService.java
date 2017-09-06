package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Client;

public interface ClientService {

	void persist(Client client) throws Exception;

	void merge(Client client) throws Exception;

	void remove(int id) throws Exception;

	List<Client> findAll() throws Exception;

	Client findById(int id) throws Exception;
	
	void virement(String numCompteDebiteur, String numCompteCrediteur, double montantTransfert) throws Exception;

}