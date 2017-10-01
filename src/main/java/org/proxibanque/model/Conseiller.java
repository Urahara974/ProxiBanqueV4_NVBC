package org.proxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Person {


	private static final long serialVersionUID = 8314519509659048610L;
	
	
	@OneToMany(mappedBy="conseiller")
	private Collection<Client> listeClients= new ArrayList<>();
	

	public Conseiller(String firstName, String lastName) {
		super(firstName, lastName);

	}

	public Conseiller() {

	}

}
