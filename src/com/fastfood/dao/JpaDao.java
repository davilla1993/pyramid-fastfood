package com.fastfood.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDao<E> {

	private static EntityManagerFactory emf;

	static {

		emf = Persistence.createEntityManagerFactory("PyramidFastfood");
	}

	public JpaDao() {

	}

	public E create(E entity) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(entity);
		em.flush();
		em.refresh(entity);

		em.getTransaction().commit();
		em.close();

		return entity;
	}

	public E update(E entity) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.merge(entity);

		em.getTransaction().commit();
		em.close();

		return entity;
	}

	public E find(Class<E> type, Object id) {

		EntityManager em = emf.createEntityManager();
		E entity = em.find(type, id);

		if (entity != null) {
			em.refresh(entity);
		}

		em.close();

		return entity;
	}

	public void delete(Class<E> type, Object id) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Object reference = em.getReference(type, id);
		em.remove(reference);

		em.getTransaction().commit();
		em.close();
	}

	public List<E> findWithNamedQuery(String queryName) {

		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);

		List<E> result = query.getResultList();
		em.close();

		return result;
	}
	
	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult) {

		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);

		List<E> result = query.getResultList();
		em.close();

		return result;
	}
	
	public List<Object[]> findWithNamedQueryObjects(String queryName, int firstResult, int maxResult) {

		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);

		List<Object[]> result = query.getResultList();
		em.close();

		return result;
	}
	
	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		
		List<E> result = query.getResultList();
		em.close();
		
		return result;
	}
	
	List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters){
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		for(Entry<String, Object> entry : setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		List<E> result = query.getResultList();
		em.close();
		
		return result;
	}
	
	
	public Long countWithNamedQuery(String queryName) {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		
		Long result = (long) query.getSingleResult();
		
		em.close();
		
		return result;
	} 
	
	public Long countWithNamedQuery(String queryName, String paramName, Object paramValue) {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		
		Long result = (long) query.getSingleResult();
		em.close();
		
		return result;
	}
	
	public void close() {
		
		if(emf != null) {
			
			emf.close();
		}
	}

}
