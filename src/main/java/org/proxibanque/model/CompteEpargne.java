/**
 * 
 */
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

/**
 * @author NVBC
 *
 */

@Entity
@DiscriminatorValue("COMPTE_EPARGNE")
public class CompteEpargne extends Compte {
	@Override
	public String toString() {
		return "CompteEpargne [getNumeroCompte()=" + getNumeroCompte() + ", getSolde()=" + getSolde() + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8899368843962326692L;
	
	@Column(name = "TAUX_REMUNERATION")
	private double tauxRemuneration = 0.03;
	
	@OneToOne(mappedBy = "compteEpargne", cascade = CascadeType.ALL)
	private Client client;

	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}


	public String creationNumeroCompteEpargne(Client client) {
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
		sb.append("-CE");
		String nouveauNumeroCompteEpargne = sb.toString();
		return nouveauNumeroCompteEpargne;
	}
	
	
	public CompteEpargne() {
	}

	public CompteEpargne(Date dateOuverture, double solde) {
		super(dateOuverture, solde);
	}

	public CompteEpargne(String numeroCompte, Date dateOuverture, double solde) {
		super(numeroCompte, dateOuverture, solde);
	}

}
