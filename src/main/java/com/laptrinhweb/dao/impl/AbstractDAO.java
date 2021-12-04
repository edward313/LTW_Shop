package com.laptrinhweb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.laptrinhweb.dao.GenericDAO;
import com.laptrinhweb.utils.DBUtil;

public class AbstractDAO<T> implements GenericDAO<T> {

	@Override
	public T insert(T obj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.persist(obj);
			trans.commit();
			return obj;
		}catch (Exception ex) {
			trans.rollback();
		}finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<T> query(String sql,Object...params ) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try{
			Class<T> resultClass = null;
			TypedQuery<T> query =	
				      em.createQuery(sql,resultClass);
			setParameter(query, params);
			List<T> results = query.getResultList();
			return results.isEmpty()?null:results;
		}catch(Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	private void setParameter(Query query, Object[] params) {
		int index = 1;
		for (Object param : params) {
			query.setParameter(index, param);
			index++;
		}
	}
	
	private void setParameterForUpDel(Query query, Object[] params) {
		int index = 1;
		for (Object param : params) {
			query.setParameter(index, param);
			index++;
		}
	}
	
	
	@Override
	public void update(T obj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(obj);
			trans.commit();
		}catch(Exception ex) {
			trans.rollback();
		}finally {
			em.close();
		}
	}

	@Override
	public T findOneById(Class<T> tClass, Long id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		return em.find(tClass, id);
	}

}
