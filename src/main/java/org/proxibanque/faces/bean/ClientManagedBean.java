package org.proxibanque.faces.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.proxibanque.dao.ClientsDao;
import org.proxibanque.model.Client;
import org.proxibanque.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="clientManagedBean")
@ViewScoped
public class ClientManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -668301491742430L;
	
	@Autowired
	private ClientService clientService;
   
	private Client client;
	
	private Client clientSelected;
	private List<Client> list;
	private List<Client> listSelected;
	
	@PostConstruct
    public void init() {
		refreshList();
    }
	
	
	private String numCompteDebiteur;
	private String numCompteCrediteur;
	private double montantTransfert;

	public String getNumCompteDebiteur() {
		return numCompteDebiteur;
	}


	public void setNumCompteDebiteur(String numCompteDebiteur) {
		this.numCompteDebiteur = numCompteDebiteur;
	}


	public String getNumCompteCrediteur() {
		return numCompteCrediteur;
	}


	public void setNumCompteCrediteur(String numCompteCrediteur) {
		this.numCompteCrediteur = numCompteCrediteur;
	}


	public double getMontantTransfert() {
		return montantTransfert;
	}


	public void setMontantTransfert(double montantTransfert) {
		this.montantTransfert = montantTransfert;
	}




	public void refreshList() {
		this.client = new Client();
		this.clientSelected = new Client();
		this.list = new ArrayList<Client>();
		this.listSelected = new ArrayList<Client>();
		this.numCompteDebiteur="";
		this.numCompteCrediteur="";
		this.montantTransfert=0.0;
		try {
			this.list.addAll(clientService.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void virement() {
		try {
			clientService.virement(this.numCompteDebiteur, this.numCompteCrediteur, this.montantTransfert);
			refreshList();
			notificationSuccess("virement");
		} catch (Exception e) {
			notificationError(e,"virement");
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
		    
			clientService.persist(this.client);
			refreshList();
			notificationSuccess("persist client");
		} catch (Exception e) {
			notificationError(e,"persist client");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			clientService.merge(this.clientSelected);
			refreshList();
			notificationSuccess("update client");
		} catch (Exception e) {
			notificationError(e,"update client");
		}
	}

	public void delete() {
		try {
			clientService.remove(this.clientSelected.getId());
			refreshList();
			notificationSuccess("delete client");
		} catch (Exception e) {
			notificationError(e,"delete client");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	
	public void reset() {
		refreshList();
        RequestContext.getCurrentInstance().reset("form1:panel");  
	}

	
	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success"); 
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClientSelected() {
		return clientSelected;
	}

	public void setClientSelected(Client clientSelected) {
		this.clientSelected = clientSelected;
	}

	public List<Client> getList() {
		if(list == null){
			list = new ArrayList<Client>();
		}
		return list;
	}

	public void setList(List<Client> list) {
		this.list = list;
	}

	public List<Client> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Client> listSelected) {
		this.listSelected = listSelected;
	}


	

}
