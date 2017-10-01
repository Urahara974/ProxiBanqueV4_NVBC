package org.proxibanque.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.proxibanque.model.Virement;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class VirementDaoImpl {
	
	
	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;
	
	@Transactional
	public void persist(Virement virement) throws HibernateException {
		getEntityManager().persist(virement);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) throws Exception {
		this.entityManager = entityManager;
	}

	public VirementDaoImpl() {
		super();
	}
	
	

}
