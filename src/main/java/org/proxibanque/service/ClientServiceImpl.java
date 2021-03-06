package org.proxibanque.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.proxibanque.dao.ClientsDao;
import org.proxibanque.dao.impl.CompteDaoImpl;
import org.proxibanque.dao.impl.VirementDaoImpl;
import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.CompteEpargne;
import org.proxibanque.model.Virement;
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
	
	@Autowired
	private VirementDaoImpl virementDao; 
	

	
	
	public ClientServiceImpl() {
		super();
	}




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
	public Client findById(String id) throws Exception {
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
		if("CC".equals(numCompteDebiteur.split("-")[numCompteDebiteur.split("-").length - 1])) {
			compteDebiteur = compteDao.infoCompteCourantDao(numCompteDebiteur).get(0);
			if(-((CompteCourant) compteDebiteur).getDecouvert() > compteDebiteur.getSolde() - montantTransfert) {
				montantTransfert = 0.0;
			}
		}else {
			compteDebiteur = compteDao.infoCompteEpargneDao(numCompteDebiteur).get(0);
			if(0 > compteDebiteur.getSolde() - montantTransfert) {
				montantTransfert = 0.0;
			}
		}
		if("CC".equals(numCompteCrediteur.split("-")[numCompteCrediteur.split("-").length - 1])) {
			compteCrediteur = compteDao.infoCompteCourantDao(numCompteCrediteur).get(0);
		}else {
			compteCrediteur = compteDao.infoCompteEpargneDao(numCompteCrediteur).get(0);
		}
		if(!numCompteDebiteur.equals(numCompteCrediteur)) {
			soldeCompteDebiteur = compteDebiteur.getSolde();
			nouveauSoldeCompteDebiteur = soldeCompteDebiteur - montantTransfert;
			compteDebiteur.setSolde(nouveauSoldeCompteDebiteur);
			soldeCompteCrediteur = compteCrediteur.getSolde();
			nouveauSoldeCompteCrediteur = soldeCompteCrediteur + montantTransfert;
			compteCrediteur.setSolde(nouveauSoldeCompteCrediteur);
			compteDao.miseAJourCompteDao(compteDebiteur);
			compteDao.miseAJourCompteDao(compteCrediteur);
		}
		Virement enregistrementVirement = new Virement(montantTransfert, numCompteDebiteur, numCompteCrediteur);
		virementDao.persist(enregistrementVirement);
	}
	
	@Override
	public List<String> listNumeroCompteAll() throws Exception {
		List<String> listComptes = new ArrayList<>();
		List<String> listCompteCourant = compteDao.listNumeroCompteCourantDaoAll();
		List<String> listCompteEpargne = compteDao.listNumeroCompteEpargneDaoAll();
		listComptes.addAll(listCompteCourant);
		listComptes.addAll(listCompteEpargne);
		return listComptes;
	}
	
}
