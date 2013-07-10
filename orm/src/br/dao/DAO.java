package br.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class DAO <T>{

	private static EntityManagerFactory factory = null;
	private Class<T> classe;
	
	static {
		
		factory = Persistence.createEntityManagerFactory("orm");
		
	}

	public DAO(){
		
        Class thisClass = getClass();
        ParameterizedType t = (ParameterizedType) thisClass.getGenericSuperclass();
        Type t2 = t.getActualTypeArguments()[0];
        this.classe = (Class) t2;
		
	}
	
	public T localizar(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		T obj = null;
		try {
			t.begin();
			obj = em.find(classe, id);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (t.isActive()) t.rollback();
		} finally {
			em.close();
		}
		return obj;
	}
	
	public void inserir(T obj) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(obj);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (t.isActive()) t.rollback();
		} finally {
				
			em.close();
				
		}
	}
	
	
}
