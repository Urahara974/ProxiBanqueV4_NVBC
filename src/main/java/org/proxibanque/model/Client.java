/**
 * 
 */
package org.proxibanque.model;

/**
 * @author NVBC
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
// @NamedQueries({
// @NamedQuery(name="items.findAll", query="select o from Item o"),
// })
@DiscriminatorValue("CLIENT")
public class Client extends Person implements Serializable {

	private static final long serialVersionUID = 1823819173451125676L;

	
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="COMPTE_COURANT")
	private CompteCourant compteCourant = new CompteCourant();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COMPTE_EPARGNE")
	private CompteEpargne compteEpargne = new CompteEpargne();
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEPHONE") // , nullable = false)
	private String telephone = "";

	@Column(name = "NUMERO_RUE")
	private int numero;

	@Column(name = "RUE")
	private String rue;

	@Column(name = "VILLE")
	private String ville;

	@Column(name = "CODE_POSTAL")
	private int codePostal;

	@ManyToOne
	private Conseiller conseiller;

	
	// Getters et Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue.trim().toLowerCase();
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville.trim().toUpperCase();
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone.trim();
	}

	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}


	
	
	// Constructeurs

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param tel
	 */
	public Client(String firstName, String lastName) {
		super(firstName, lastName);
	}



	public Client(String firstName, String lastName, CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super(firstName, lastName);
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public Client(String firstName, String lastName, String email, String telephone, int numero, String rue,
			String ville, int codePostal) {
		super(firstName, lastName);
		this.email = email;
		this.telephone = telephone;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Client() {
	}

}
