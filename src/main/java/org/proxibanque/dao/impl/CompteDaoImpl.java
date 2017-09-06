package org.proxibanque.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.CompteEpargne;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CompteDaoImpl {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	
	@Transactional(readOnly = true)
	public List<Compte> listeInfosCompteDao() throws Exception {
		List<Compte> reList = new ArrayList<Compte>();
		String sql = "from comptes";
		TypedQuery<Compte> query = getEntityManager().createQuery(sql, Compte.class);
		reList = query.getResultList();
		return reList;
	}
	
	@Transactional(readOnly = true)
	public Compte infoCompteDao(String numCompte) throws Exception {
		Compte compte;
		compte = getEntityManager().find(Compte.class, numCompte);
		return compte;
	}
	
	@Transactional(readOnly = true)
	public Compte infoCompteCourantDao(String numCompteCourant) throws Exception {
		Compte compte = new CompteCourant();
		compte = getEntityManager().find(Compte.class, numCompteCourant);
		return compte;
	}
	
	@Transactional(readOnly = true)
	public Compte infoCompteEpargneDao(String numCompteEpargne) throws Exception {
		Compte compte = new CompteEpargne();
		compte = getEntityManager().find(Compte.class, numCompteEpargne);
		return compte;
	}

	@Transactional
	public void miseAJourCompteDao(Compte compte) throws Exception {
		getEntityManager().merge(compte);
	}




	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) throws Exception {
		this.entityManager = entityManager;
	}
	
}
