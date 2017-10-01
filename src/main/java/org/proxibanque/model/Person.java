package org.proxibanque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name = "PERSONNES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSONNE", discriminatorType = DiscriminatorType.STRING)
public class Person implements Serializable {

	private static final long serialVersionUID = 1924485545639124982L;

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "FIRST_NAME")
	private String firstName = "";
	
	@Column(name = "LAST_NAME")
	private String lastName = "";
	

	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.trim().toLowerCase();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.trim().toUpperCase();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	// Constructors
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
	}

}
