package org.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.proxibanque.dao.ClientsDao;
import org.proxibanque.dao.impl.CompteDaoImpl;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="clientService")
@ViewScoped
public class ClientServiceImpl implements Serializable, ClientService {

	private static final long serialVersionUID = -7687518819258150371L;

	@Autowired
	private ClientsDao clientDao;
	
	@Autowired
	private CompteDaoImpl compteDao;
	

	public ClientsDao getClientDao() {
		return clientDao;
	}


	public void setClientDao(ClientsDao clientDao) {
		this.clientDao = clientDao;
	}


	public CompteDaoImpl getCompteDao() {
		return compteDao;
	}


	public void setCompteDao(CompteDaoImpl compteDao) {
		this.compteDao = compteDao;
	}



	@Override
	public void persist(Client client) throws Exception {
		client.getCompteCourant().setNumeroCompte(client.getCompteCourant().creationNumeroCompteCourant(client));
		client.getCompteEpargne().setNumeroCompte(client.getCompteEpargne().creationNumeroCompteEpargne(client));
		clientDao.persist(client);
	}
	

	@Override
	public void merge(Client client) throws Exception {
		clientDao.merge(client);
	}
	

	@Override
	public void remove(int id) throws Exception {
		clientDao.remove(id);
	}
	

	@Override
	public List<Client> findAll() throws Exception{
		return clientDao.findAll();
	}
	

	@Override
	public Client findById(int id) throws Exception {
		return clientDao.findById(id);
	}
	
	@Override
	public void virement(String numCompteDebiteur, String numCompteCrediteur, double montantTransfert) throws Exception {
		Compte compteDebiteur;
		Compte compteCrediteur;
		double soldeCompteDebiteur;
		double soldeCompteCrediteur;
		double nouveauSoldeCompteDebiteur;
		double nouveauSoldeCompteCrediteur;
		compteDebiteur = compteDao.infoCompteDao(numCompteDebiteur);
		compteCrediteur = compteDao.infoCompteDao(numCompteCrediteur);
		soldeCompteDebiteur = compteDebiteur.getSolde();
		soldeCompteCrediteur = compteCrediteur.getSolde();
		nouveauSoldeCompteDebiteur = soldeCompteDebiteur - montantTransfert;
		nouveauSoldeCompteCrediteur = soldeCompteCrediteur + montantTransfert;
		compteDebiteur.setSolde(nouveauSoldeCompteDebiteur);
		compteCrediteur.setSolde(nouveauSoldeCompteCrediteur);
		compteDao.miseAJourCompteDao(compteDebiteur);
		compteDao.miseAJourCompteDao(compteCrediteur);
	}
	
}
