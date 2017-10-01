package org.proxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

public class Gerant extends Conseiller {
	

	private static final long serialVersionUID = -6753742755943236175L;


	private Collection<Conseiller> listeConseillers = new ArrayList<>();
	
	

	public Collection<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	public void setListeConseillers(Collection<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}


	public Gerant(String firstName, String lastName) {
		super(firstName, lastName);
	}


	public Gerant() {
	}

}
