/**
 * 
 */
package org.proxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

/**
 * @author NVBC
 *
 */
public class Gerant extends Conseiller {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6753742755943236175L;

//	@OneToMany(mappedBy="gerant")
	private Collection<Conseiller> listeConseillers = new ArrayList<>();
	
	
	
	
	/**
	 * @return the listeConseillers
	 */
	public Collection<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	/**
	 * @param listeConseillers the listeConseillers to set
	 */
	public void setListeConseillers(Collection<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param tel
	 */
	public Gerant(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/**
	 * 
	 */
	public Gerant() {
	}

}
