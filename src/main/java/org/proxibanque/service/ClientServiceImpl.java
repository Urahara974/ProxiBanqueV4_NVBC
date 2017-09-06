package org.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.proxibanque.dao.ClientsDao;
import org.proxibanque.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="clientService")
@ViewScoped
public class ClientServiceImpl implements Serializable, ClientService {

	private static final long serialVersionUID = -7687518819258150371L;

	@Autowired
	private ClientsDao clientDao;
	

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
	
}
