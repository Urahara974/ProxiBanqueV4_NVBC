/**
 * 
 */
package org.proxibanque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author NVBC
 *
 */
@Entity
@Table(name="VIREMENTS")
public class Virement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7964504933609514948L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numOperation;
	private Date dateOperation;
//	private String typeOperation;
	private double montant;
	@Column(name="CPTE_SOURCE")
	private String numCompteSource;
	@Column(name="CPTE_CIBLE")
	private String numCompteCible;

	@ManyToOne
	@JoinColumn(name = "NUMEROCOMPTE")
	private Compte compte;

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Constructeur par defaut
	 */
	public Virement() {
		super();
	}


	/**
	 * 
	 */
	public Virement(Long numOperation, Date dateOperation, double montant, String numCompteSource,
			String numCompteCible) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.numCompteSource = numCompteSource;
		this.numCompteCible = numCompteCible;
	}

	
	

}
