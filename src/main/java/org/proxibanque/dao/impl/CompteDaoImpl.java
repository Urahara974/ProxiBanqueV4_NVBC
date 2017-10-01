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
		String sql = "from compte";
		TypedQuery<Compte> query = getEntityManager().createQuery(sql, Compte.class);
		reList = query.getResultList();
		return reList;
	}
	
	
	@Transactional(readOnly = true)
	public Compte infoCompteDao(String numCompte) throws Exception {
		return (Compte) getEntityManager()
				.createQuery("from comptes where NUMERO_COMPTE = ?1")
				.setParameter(1, numCompte).getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<String> listNumeroCompteCourantDaoAll() throws Exception {
		return (List<String>) getEntityManager()
				.createQuery("select cc.numeroCompte from CompteCourant cc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<String> listNumeroCompteEpargneDaoAll() throws Exception {
		return (List<String>) getEntityManager()
				.createQuery("select ce.numeroCompte from CompteEpargne ce")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Compte> infoCompteCourantDao(String numCompteCourant) throws Exception {
		
		return (List<Compte>) getEntityManager()
				.createQuery("from CompteCourant cc where cc.numeroCompte = ?1")
				.setParameter(1, numCompteCourant).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Compte> infoCompteEpargneDao(String numCompteEpargne) throws Exception {
				return (List<Compte>) getEntityManager()
				.createQuery("from CompteEpargne ce where ce.numeroCompte = ?1")
				.setParameter(1, numCompteEpargne).getResultList();
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

	public CompteDaoImpl() {
		super();
	}
	
	
	
	
}
