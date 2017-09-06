/**
 * 
 */
package org.proxibanque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author NVBC
 *
 */

@Entity
//@ManagedBean
@Table(name="COMPTES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte implements Serializable{

	private static final long serialVersionUID = 1642164815869537676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "NUMERO_COMPTE")
	private String numeroCompte;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OUVERTURE")
	private Date dateOuverture = new Date();
	@Column(name = "SOLDE")
	private double Solde;
	
	private String numeroAgence = "PARIS12";
	
	
	@OneToMany(mappedBy="compte", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Virement> listeVirements;




	
	
	// ************************************

	// Getters et Setters
	

	public String getNumeroCompte() {
		return numeroCompte;
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", Solde=" + Solde + "]";
	}

	public String getNumeroAgence() {
		return numeroAgence;
	}

	public void setNumeroAgence(String numeroAgence) {
		this.numeroAgence = numeroAgence;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public double getSolde() {
		return Solde;
	}

	public void setSolde(double solde) {
		Solde = solde;
	}

	public List<Virement> getListeVirements() {
		return listeVirements;
	}

	public void setListeVirements(List<Virement> listeVirements) {
		this.listeVirements = listeVirements;
	}
	
	
	/**
	 * Constructeur par defaut
	 */
	public Compte() {
	}

	/**
	 * Constructeur en utilisant les parametres :
	 * 
	 * @param numeroCompte
	 * @param dateOuverture
	 * @param solde
	 */
	public Compte(Date dateOuverture, double solde) {
		this.dateOuverture = dateOuverture;
		Solde = solde;
	}

	
	public Compte(String numeroCompte, Date dateOuverture, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.dateOuverture = dateOuverture;
		Solde = solde;
	}
	
	


}
