package repository;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Genero;

public class GeneroRepository {
	
	private EntityManager entityManager;
	
	public GeneroRepository(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public Genero search(Long ID){
		return this.entityManager.find(Genero.class,ID);
	}
	
	@SuppressWarnings("rawtypes")
	public List getGeneros(){
		return this.entityManager.createNamedQuery("Genero.findAll").getResultList();
	}

}
