package org.proxibanque.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("COMPTE_COURANT")
public class CompteCourant extends Compte {


	@Override
	public String toString() {
		return "CompteCourant [getSolde()=" + getSolde() + "]";
	}

	private static final long serialVersionUID = 3767712002819697465L;


	@Column(name = "DECOUVERT")
	private double decouvert = 1000;
	
	@OneToOne(mappedBy = "compteCourant", cascade = CascadeType.ALL)
	private Client client;
	
	@Column(name = "NUMERO_COMPTE")
	private String numeroCompte;

	
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	public String getNumeroCompte() {
		return numeroCompte;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public String creationNumeroCompteCourant(Client client) {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(super.getDateOuverture());
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int min = cal.get(Calendar.MINUTE);
	    int sec = cal.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		sb.append(client.getLastName().substring(0, 1).toUpperCase());
		sb.append(client.getFirstName().substring(0, 1).toUpperCase());
		sb.append("-");
		sb.append(year);
		sb.append(month);
		sb.append(day);
		sb.append(min);
		sb.append(sec);
		sb.append("-");
		sb.append(super.getNumeroAgence());
		sb.append("-CC");
		String nouveauNumeroCompteCourant = sb.toString();
		return nouveauNumeroCompteCourant;
	}
	
	
	public CompteCourant() {
	}


	public CompteCourant(Date dateOuverture, double solde) {
		super(dateOuverture, solde);
	}


}
